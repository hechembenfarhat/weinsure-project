package tn.weinsure1.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.servlet.http.Part;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.ContractType;
import tn.weinsure1.entities.Contraint;
import tn.weinsure1.entities.ContraintType;
import tn.weinsure1.entities.User;
import tn.weinsure1.service.IContractService;
import tn.weinsure1.service.IContraintService;
import tn.weinsure1.service.IUserService;
import tn.weinsure1.service.IsinisterService;

@Scope(value = "session")
@Controller(value = "ContraintController")
@ELBeanName(value = "ContraintController")
public class ContraintController {
	@Autowired
	IContraintService ics;
	
	@Autowired
	IsinisterService is ;

	private List<Contraint> listContraints;
	private List<Contraint> listContraintsClients;
	private List<Contraint> listContraintsnonlus;

	private String description;
	private int state;
	int duree ;
	float mensualite; 
	float capitalemprente ;
	private byte[] documents;
	ContraintType type;
	private String reponse;
	private User user;
	
	private String outputCCE;
	private String outputCCE1;
	private String outputCM;
	
	public String getOutputCCE1() {
		return outputCCE1;
	}

	public void setOutputCCE1(String outputCCE1) {
		this.outputCCE1 = outputCCE1;
	}

	private Part uploadedFile;
	private String folder = "C:\\files";
	
	private StreamedContent dbImage;
	
	
	private PieChartModel barchart ;
	
	
	public StreamedContent getimblob(byte[] doc) {
		InputStream stream = new ByteArrayInputStream(doc);
		return new DefaultStreamedContent(stream, "image/jpeg/png");
	}
	
	public Part getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public String getOutputCCE() {
		return outputCCE;
	}
	public void setOutputCCE(String outputCCE) {
		this.outputCCE = outputCCE;
	}
	public String getOutputCM() {
		return outputCM;
	}
	public void setOutputCM(String outputCM) {
		this.outputCM = outputCM;
	}

	private long IdToBeUpdated;
	//private String a =Long.toString(IdToBeUpdated) ;
	// get Contraint Affichage
	public List<Contraint> getListContraints() {
		listContraints = ics.RetrieveAllContraints();
		System.err.println(getTypes().length);
		return listContraints;
	} 
   public List<Contraint> getListContraintsClients() {
	/*	int j=0;
		listContraints = ics.RetrieveAllContraints();
		System.err.println(getTypes().length);
		for ( int i =0 ; i<listContraints.size() ; i++){
			if(listContraints.get(i).getState()!=1){
			listContraintsClients.set(j,listContraints.get(i))	;
			j++; 
			System.err.println(j);
			System.err.println("aaaaaaaaaaaaaaa");}
		}*/
	   
	   listContraintsClients = ics.contraintFiltreState(0);
	   listContraintsClients.addAll(ics.contraintFiltreState(2)) ;
		return listContraintsClients;
	} 
	
	/*public List<Contraint> affichClient(){
	/*	int j=0;
		List<Contraint> l = ics.RetrieveAllContraints();
		List<Contraint> ll = new ArrayList<Contraint>();
		System.err.println(getTypes().length);
		for ( int i =0 ; i<l.size() ; i++){
			System.err.println("Allo");
			
				ll.add(l.get(i))	;
				System.err.println("bonjour");
			
				
				
		}
		return ll;
		
	}*/
	public List<Contraint> getListContraintsnonlus() {
		listContraintsnonlus = ics.contraintFiltreState(0);
		System.err.println(getTypes().length);
		return listContraintsnonlus;
	} 
	
	public List<Contraint> getListContraintslus() {
		listContraintsnonlus = ics.contraintFiltreState(2);
		System.err.println(getTypes().length);
		return listContraintsnonlus;
	}


	public void setListContraints(List<Contraint> listContraints) {
		this.listContraints = listContraints;
	}

	public ContraintType[] getTypes() {
		return ContraintType.values();
	}
	
	
	//ADD
	public void updateContraint(){
		ics.UpdateContraint(new Contraint(IdToBeUpdated, state, description, documents, type));
	}
	//repondre 
	public void RepndreContraint(){
		ics.repondreContraint(Long.toString(IdToBeUpdated), reponse);
	}
  
	public void RepndreContraint1(Contraint c){
		System.err.println("Repondre");
		ics.repondreContraint(String.valueOf(c.getIdcontraint()), reponse);
	}
	// DELETE Contraint
	public void deleteContraint(String id) {
		ics.DeleteContraint(id);
	}

	public void addContraint() {
		ics.AddContraint(new Contraint(0, description, documents, type));
	}

	// Afficher une contraint dans les inputs
	public void afficherContraint(Contraint c) {
		this.setDescription(c.getDescription());
		this.setState(c.getState());
		this.setType(c.getType());
		this.setDocuments(c.getDocuments());
		this.setIdToBeUpdated(c.getIdcontraint());
	} 
	
	

	// GETTERS & SETTERS
	
	public String getDescription() {
		return description;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public float getMensualite() {
		return mensualite;
	}
	public void setMensualite(float mensualite) {
		this.mensualite = mensualite;
	}
	public float getCapitalemprente() {
		return capitalemprente;
	}
	public void setCapitalemprente(float capitalemprente) {
		this.capitalemprente = capitalemprente;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public byte[] getDocuments() {
		return documents;
	}

	public void setDocuments(byte[] documents) {
		this.documents = documents;
	}

	public ContraintType getType() {
		return type;
	}

	public void setType(ContraintType type) {
		this.type = type;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getIdToBeUpdated() {
		return IdToBeUpdated;
	}

	public void setIdToBeUpdated(long idToBeUpdated) {
		IdToBeUpdated = idToBeUpdated;
	}
	
	// FIN GETTERS & SETTERS
 
	//simulateur credit  
			public void creditSimulator_mensualatie(){
				Long l2=Long.valueOf(1);
				float f = is.creditSimulator_mensualatie(l2,l2,capitalemprente,duree);
				this.setOutputCCE(String.valueOf(f));
			 	
			} 
			
			public void creditSimulator_capitalemprunte(){
				Long l2=Long.valueOf(1);
				
				if(mensualite <=0 ){
					FacesMessage facesMessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"Erreur", "Veuillez inserer une mensualite valide");
					FacesContext.getCurrentInstance().addMessage("hihi:awah", facesMessage);
				}
					
				else{
				float f = is.creditSimulator_capitalemprunte(l2,l2,mensualite,duree);
				this.setOutputCCE1(String.valueOf(f));
				}
			}

			
		/*	
			public void handleFileUpload(FileUploadEvent event) {
			    byte[] content = event.getFile().getContents();
			    // ...
			}
	*/
			
			
			public PieChartModel getBarchart() {
				barchart = new PieChartModel();
				List<Map<String, BigInteger>> jj = ics.statistiqueDate();
				for ( int i =0 ; i<jj.size() ; i++){
					//Integer[] aKeys = jj.get(i).keySet().toArray(new Integer[jj.get(i).size()]);
					barchart.set(String.valueOf(jj.get(i).get("date")),jj.get(i).get("nombre_reclamation"));
				}
				
				
				barchart.setTitle("Contraint per Date");
				barchart.setLegendPosition("w");
				return barchart;
			}
			public void setBarchart(PieChartModel barchart) {
				this.barchart = barchart;
			}
			
			
			public StreamedContent getDbImage() {
				return dbImage;
			}
			public void setDbImage(StreamedContent dbImage) {
				this.dbImage = dbImage;
			}

			public void setListContraintsClients(List<Contraint> listContraintsClients) {
				this.listContraintsClients = listContraintsClients;
			}
			
			
	
	
			
			
}
