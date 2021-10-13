package tn.weinsure1.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Sinistre")
public class sinister implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdSinistre")
	private Long idSinistre ;
	
    @Enumerated(EnumType.STRING)
    @Column(name="TypeSinistre")
	typeSinister typeSinistre;
     
	private String description;
	@Temporal(TemporalType.DATE)
    @Column(name="DateOccurence")
	private Date dateOccurence;
	
	@Enumerated(EnumType.STRING)
    @Column(name="Status" , nullable=false)
	private sinisterstatus status;
	
	@Column(name="Documents")
	private File documents ;
	
	@Enumerated(EnumType.STRING)
    @Column(name="Motif")
	SinisterMotif motifStatus;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID",referencedColumnName="USER_ID")
	@JsonIgnoreProperties("sinisterList")
	@JsonIgnore
	private User user;


	
	public Long getIdSinistre() {
		return idSinistre;
	}

	public void setIdSinistre(Long idSinistre) {
		this.idSinistre = idSinistre;
	}

	public typeSinister getTypeSinistre() {
		return typeSinistre;
	}

	public void setTypeSinistre(typeSinister typeSinistre) {
		this.typeSinistre = typeSinistre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOccurence() {
		return dateOccurence;
	}

	public void setDateOccurence(Date dateOccurence) {
		this.dateOccurence = dateOccurence;
	}

	public sinisterstatus getStatus() {
		return status;
	}

	public void setStatus(sinisterstatus status) {
		this.status = status;
	}

	public File getDocuments() {
		return documents;
	}

	public void setDocuments(File documents) {
		this.documents = documents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public SinisterMotif getMotifStatus() {
		return motifStatus;
	}

	public void setMotifStatus(SinisterMotif motifStatus) {
		this.motifStatus = motifStatus;
	}

	@Override
	public String toString() {
		return "Sinistre [idSinistre=" + idSinistre + ", typeSinistre=" + typeSinistre + ", description=" + description
				+ ", dateOccurence=" + dateOccurence + ", status=" + status + ", documents=" + documents + "]";
	}
	

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence, sinisterstatus status,
			File documents, SinisterMotif motifStatus, User user) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.motifStatus = motifStatus;
		this.user = user;
	}

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence, sinisterstatus status,
			File documents, User user) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.user = user;
	}

	public sinister(Long idSinistre, tn.weinsure1.entities.typeSinister typeSinistre, String description,
			Date dateOccurence, sinisterstatus status, File documents) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
	}

	public sinister() {
		super();
	}

	public sinister(tn.weinsure1.entities.typeSinister typeSinistre, String description, Date dateOccurence,
			sinisterstatus status, File documents) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
	}

	
	
	


}