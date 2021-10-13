package tn.weinsure1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.weinsure1.entities.TableMortalité;



public interface TableMortalitéRepository  extends CrudRepository<TableMortalité, Long> {
	@Query("select t.Tv_99 from TableMortalité t where t.x = ?1 ") //LIMIT 1
	float findBySurvivantsLx(int ageClient);

	@Query("select t.Td_99 from TableMortalité t where t.x = ?1 ")
	float findByDecesDx(int deces);
	
	@Query("select t.proba from TableMortalité t where t.x = ?1 ")
	float findProbaByAgeClient(int ageClient);
	
	@Query("select MAX(t.x) from TableMortalité t  ")
	int findAgeMax();


}
