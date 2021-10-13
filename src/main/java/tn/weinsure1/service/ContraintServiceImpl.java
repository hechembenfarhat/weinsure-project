package tn.weinsure1.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Contraint;
import tn.weinsure1.entities.User;
import tn.weinsure1.entities.Contraint;
import tn.weinsure1.repository.ContraintRepository;
import tn.weinsure1.repository.ContraintRepository;
import tn.weinsure1.repository.UserRepository;

@Service
public class ContraintServiceImpl implements IContraintService {

	@Autowired
	ContraintRepository ContraintRepository;
	@Autowired
	UserRepository UserRepository;
	
	private static final Logger L= LogManager.getLogger(ContraintServiceImpl.class);
	@Override
	public List<Contraint> RetrieveAllContraints(){
		List<Contraint> users = (List<Contraint>) ContraintRepository.findAll();
		for (Contraint user : users){
			L.info("user +++ :" + user);
		}
		return users;
	}
	@Override
	public Contraint AddContraint(Contraint c) {
		 Contraint c1 = ContraintRepository.save(c);
		 return c1;
	
	}
	@Override
	public void DeleteContraint(String id) {
		ContraintRepository.deleteById(Long.parseLong(id));
	}
	@Override
	public String UpdateContraint(Contraint c) {  // 0 : non traitée 1  en cours de traitement 2: traité
		int state = ContraintRepository.findById(c.getIdcontraint()).get().getState();
		if (state < 1 ){
			Contraint ContraintUpdated = ContraintRepository.save(c);
			return "Containt Update ok";
		}
		return "No update Containt ";
		
	}
	
	@Override
	public Contraint RetrieveContraint(String id) {
		L.info("in RetrieveContraint id = " + id);
		Contraint c = ContraintRepository.findById(Long.parseLong(id)).get();
		L.info("Contraint returned = : " + c);
		return c;	
	}
	
	@Override
	public List<Contraint> contraintFiltreFeedback() {
		List<Contraint> cont = ContraintRepository.contraintFiltreFeedback();
		return cont;
	}
	
	@Override
	public List<Contraint> contraintFiltreReclmation() {
		List<Contraint> cont = ContraintRepository.contraintFiltreReclmation();
		return cont;
	}
	
	@Override
	public List<Contraint> contraintFiltreState(int state) {
		List<Contraint> cont = ContraintRepository.contraintFiltreState(state);
		return cont;
	}
	@Override
	public String repondreContraint(String id, String resp) {
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//User u = ((User)principal);

		Contraint c = ContraintRepository.findById(Long.parseLong(id)).get();
		c.setReponse(resp);
		c.setState(2);
		ContraintRepository.save(c);
		return "Vous avez repondu à la reclamation "+ c.getIdcontraint() ;
	}
	
	@Override
	public List<Contraint> getAllBetweenDates(LocalDate start, LocalDate end) {
		return ContraintRepository.getAllBetweenDates(start, end);
	}
	
	@Override
	public  List<Map<String, BigInteger>> statistiqueDate() {
		System.err.println(ContraintRepository.CountContraint());
		return ContraintRepository.CountContraint();
	}
	
	@Override
	public Contraint findById(Long id) {
		Contraint  c = ContraintRepository.findByIdContrainte(id);
		return c;
	}
	
	
	
	
}
