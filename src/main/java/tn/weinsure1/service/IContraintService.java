package tn.weinsure1.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import tn.weinsure1.entities.Contraint;

public interface IContraintService {
	List<Contraint> RetrieveAllContraints(); 
	Contraint AddContraint(Contraint c);
	void DeleteContraint(String id);
	String UpdateContraint(Contraint c);
	Contraint RetrieveContraint(String id);
	
	List<Contraint> contraintFiltreFeedback() ;
	List<Contraint> contraintFiltreReclmation() ;
	List<Contraint> contraintFiltreState(int state) ;
	
	String repondreContraint(String id , String resp);
	
	List<Contraint> getAllBetweenDates(LocalDate  start , LocalDate  end);
	
	 List<Map<String, BigInteger>> statistiqueDate() ;
	 Contraint findById(Long id);
}
