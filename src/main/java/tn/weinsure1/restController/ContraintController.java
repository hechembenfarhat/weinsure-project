package tn.weinsure1.restController;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import org.springframework.http.MediaType;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Contraint;
import tn.weinsure1.entities.ContraintType;
import tn.weinsure1.entities.User;
import tn.weinsure1.service.IContraintService;

@RestController
public class ContraintController {
	
	@Autowired
	IContraintService ics;
	
	@PostMapping("/addContraint")
	public ResponseEntity addContraint( @RequestParam("description") String description,@RequestParam("type") String type,@RequestParam("documents") MultipartFile documents) {
		
		Contraint c1 = new Contraint();
		try {
			c1.setDocuments(documents.getBytes());
			c1.setState(0);
			c1.setDescription(description);
			if (description.toString().length()<1){ 
				
				return new ResponseEntity<>("description vide ", HttpStatus.BAD_REQUEST);
				
			}
			
			
			
			
			
			
			if(!type.equals("feedback") && !type.equals("reclmation") && !type.equals("SinisterReclamation")) {
				return new ResponseEntity<>("type non connu ", HttpStatus.BAD_REQUEST);
			} else {
				if(type.equals("feedback"))
				{
					c1.setType(ContraintType.feedback);
				}
				if(type.equals("reclmation"))
				{
					c1.setType(ContraintType.reclmation);
				}
				if(type.equals("SinisterReclamation"))
				{
					c1.setType(ContraintType.SinisterReclamation);
				} 
			}
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 Contraint contResponse = ics.AddContraint(c1);
		 
		 String fileDownloadUri1 = ServletUriComponentsBuilder.fromCurrentContextPath().path("/Media/")
				 .path(String.valueOf(contResponse.getIdcontraint())).path("/image").toUriString();

			//return fileDownloadUri1;
			return new ResponseEntity<>(fileDownloadUri1, HttpStatus.ACCEPTED);
	}
	
	
	// http://localhost:8081/Dari/servlet/Media/{id}/image
		@GetMapping("/Media/{id}/image")
		public ResponseEntity downloadFile(@PathVariable("id") Long id) {
			Contraint m = ics.findById(id);
			//System.err.println(m);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; id=\"" + id + "\"").body(m.getDocuments());
		}
	
	@GetMapping("/retrieveAllContraints")
	@ResponseBody
	public List<Contraint> getContraint() {
		 List<Contraint> c = ics.RetrieveAllContraints();
		 
		 return c;
	 }
	
	@DeleteMapping("/deleteContraints/{idcontract}")
	@ResponseBody
	public void removeUser(@PathVariable("idcontract") String idc) {
		ics.DeleteContraint(idc);
	}
	
	@PutMapping("/updateContraint")
	@ResponseBody	
	public String updateContraint(@RequestBody Contraint c) {
		return ics.UpdateContraint(c);
	}
	
	@GetMapping("/filtreType/{type}")
	@ResponseBody
	public List<Contraint> contraintFiltre(@PathVariable("type") String type){
		
		if( type.equals("feedback"))
			return ics.contraintFiltreFeedback();
		
		return ics.contraintFiltreReclmation();
	}	
	
	@GetMapping("/filtreState/{state}")
	@ResponseBody
	public List<Contraint> contraintFiltreState(@PathVariable("state") int state){
		
		return ics.contraintFiltreState(state);
	}	
	
	@PutMapping("/repondre")
	@ResponseBody	
	public String repondreContraint(@RequestBody Map<String, String> json) {
		return ics.repondreContraint(json.get("id") , json.get("rep"))	;	
	}
	
	@GetMapping("/filtreDates")
	@ResponseBody
	public List<Contraint> contraintFiltreState(@RequestBody Map<String, String> json){
		return ics.getAllBetweenDates(LocalDate.parse(json.get("start")), LocalDate.parse(json.get("end")) );
	}
	
	@GetMapping("/stat")
	@ResponseBody
	public  List<Map<String, BigInteger>> contraintFiltreState(){
		
		//JSONObject jj = new JSONObject(ics.statistiqueDate());
		System.out.println(ics.statistiqueDate().size());
		return ics.statistiqueDate();
		
	}

}




class con2 implements Serializable{
    Long idcontraint;
	int state;
	String description;
    String documents;
	Date datecontraint;
	ContraintType type;
	String reponse;
	public con2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public con2(Long id, int state, String description , String reponse, String documents, Date datecontraint, ContraintType type) {
		super();
		this.idcontraint = id;
		this.state = state;
		this.description = description;
		this.documents = documents;
		this.datecontraint = datecontraint;
		this.type = type;
		this.reponse = reponse ;
	}
	
	
	

}
