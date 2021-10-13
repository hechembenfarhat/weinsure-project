package tn.weinsure1.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Contraint;



@Repository

public interface ContraintRepository extends CrudRepository<Contraint,Long>  {

	@Query("SELECT c from Contraint c WHERE c.type = 'feedback' ")
	List<Contraint> contraintFiltreFeedback();
	
	@Query("SELECT c from Contraint c WHERE c.type = 'reclmation' ")
	List<Contraint> contraintFiltreReclmation();
	
	@Query("SELECT c from Contraint c WHERE c.state = ?1 ")
	List<Contraint> contraintFiltreState(int state);
	
	@Query("SELECT c from Contraint c WHERE c.idcontraint = ?1 ")
	Contraint findByIdContrainte(Long id);
	
	@Query(value = "SELECT * FROM contraint WHERE date_contraint BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<Contraint> getAllBetweenDates(@Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
	                                    @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate);
	
	
	@Query(value = "Select date(date_contraint) as date , count(*) as nombre_reclamation from Contraint Group By date(date_contraint) ", nativeQuery = true)
	public List<Map<String, BigInteger>> CountContraint();
}
