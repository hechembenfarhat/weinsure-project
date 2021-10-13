package tn.weinsure1.restController;
import java.text.ParseException; 
import java.util.List;    
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.weinsure1.entities.User;
import tn.weinsure1.entities.sinister;
import tn.weinsure1.entities.sinisterstatus;
import tn.weinsure1.service.ITableMortaliteService;
import tn.weinsure1.service.IsinisterService;
import tn.weinsure1.service.TableMortaliteService;
@RestController
public class sinisterrestController {
	@Autowired
	IsinisterService sr;
	@Autowired
	ITableMortaliteService ts;
	private static final Logger L= LogManager.getLogger(TableMortaliteService.class);
	// http://localhost:8000/SpringMVC/servlet/retrieve-All-Sinistres 
		 @GetMapping("/retrieve-All-Sinistres")
		 @ResponseBody
		 public List<sinister> getSinister() {
		 List<sinister> s = sr.retrieveAllSinistres();
		 return s;
		 } 
			// http://localhost:8000/SpringMVC/servlet/getSinisterBystatus/
		 @GetMapping("/getSinisterBystatus/{id}")
		 @ResponseBody
		 public List<sinister> getsinisterbystat(@PathVariable(value = "id") Long id) {
		 List<sinister> s = sr.findbyuserid(id);
		 return s;
		 } 
		 @GetMapping("/getSinisterBystatuss/{id}")
		 @ResponseBody
		 public int getduration(@PathVariable(value = "id") Long id) {
		 int s = sr.findcontractdurationBysinister(id);
		 return s;
		 } 
		 // Ajouter sinister : http://localhost:8000/SpringMVC/servlet/add-sinistre
		  @PostMapping("/add-sinistre/{id}")
		  @ResponseBody
		  public sinister addSinister(@RequestBody sinister s, @PathVariable Long id) {
			  s.setStatus(sinisterstatus.enAttente);
		  return sr.addSinistre(s,id);
		  
		  }
		  @GetMapping("/calculCVE/{idU}/{idC}")
		  @ResponseBody
		  public float calculCVE(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC){
				float k = 0 ;
				k = (float) sr.CVE(idU, idC) ; 
				return k ;
			  
			}
		@GetMapping("/calculCD/{idU}/{idC}")
		@ResponseBody
		public float CapitalCasDéces(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC) throws ParseException{
		float k = 0 ;
		k = (float) sr.CapitalCasDéces(idU, idC) ; 
		return k ;
	  
	}

		@GetMapping("/calculCDP/{idU}/{idC}")
		@ResponseBody
		public float CapitalDécesPeriodique(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC) throws ParseException{
		float k = 0 ;
		k = (float) sr.CapitalDécesPeriodique(idU, idC) ; 
		return k ;
	  
	}
		@GetMapping("/calculTDE/{idU}/{idC}")
		@ResponseBody
		public float TDEMPRUNTEUR(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC) throws ParseException{
		float k = 0 ;
		k = (float) sr.TDEMPRUNTEUR(idU, idC) ; 
		return k ;
	  
	}
  
		  //http://localhost:8000/SpringMVC/servlet/aff-sinistre/10/10
		  @PutMapping(value = "/aff-sinistre/{idSin}/{idUser}") 
		  public void affecterEmployeADepartement(@PathVariable("idSin")Long idSin, @PathVariable("idUser")Long idUser) {
		  sr.affecterSinisterUser(idSin, idUser);
		  }
		  @GetMapping("/creditsimul/{idU}/{idC}")
		  @ResponseBody
		  public float creditsimul(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC){
				float k = 0 ;
				k = (float) sr.CreditSimulator( idU, idC) ; 
				return k ;
			  
			}
		     @PutMapping("/CheckStatus")
			 public void checkStatus() {
			 sr.CheckStatus();
			 } 
		     @PutMapping("/sendMail")
			 public void sendMail() {
			 sr.SendMail();
			 }
		    @PutMapping(value = "/modifyDescription/{idS}/{newdescription}") 
		 	@ResponseBody
		 	public void mettreAjourEmailByEmployeId(@PathVariable("idS") Long idS, @PathVariable("newdescription") String disc) {
		 		sr.UpdateSinDescription(idS, disc);
		 		
		 	}
		     
////////////////heshem 
	  @GetMapping("/creditSimulator_mensualatie/{idU}/{idC}/{capitalemprente}/{duree}")
	  @ResponseBody
	  public float creditSimulator_mensualatie(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC, @PathVariable("capitalemprente") float capitalemprente, @PathVariable("duree") int duree){
			float k = 0 ;
			k = sr.creditSimulator_mensualatie(idU,idC,capitalemprente,duree) ; 
			return k ;
		  
		}
	  
	  @GetMapping("/creditSimulator_capitalemprunte/{idU}/{idC}/{capitalemprente}/{duree}")
	  @ResponseBody
	  public float creditSimulator_capitalemprunte(@PathVariable("idU") Long idU, @PathVariable("idC") Long idC, @PathVariable("capitalemprente") float capitalemprente, @PathVariable("duree") int duree){
			float k = 0 ;
			k = sr.creditSimulator_capitalemprunte(idU,idC,capitalemprente,duree) ; 
			return k ;
		  
		}
	  //////////////
		  
				}

