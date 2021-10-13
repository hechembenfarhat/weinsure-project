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
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Contraint")
public class Contraint implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IDContraint")
	private Long idcontraint;
	
	
	@Column(name="State")
	private int state;

	@Column(name="Description")
	private String description;
	
	
	
	@Lob
    @Column(name = "documents", length = Integer.MAX_VALUE, nullable = true)
    private byte[] documents;
	
	@Column(name = "DateContraint", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date datecontraint;
	
	@Column(name="Type")
	@Enumerated(EnumType.STRING)
	ContraintType type;

	/*@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IDNotice")
	private Notice notice ;*/
	
	@Column(name="Reponse")
	private String reponse;
	
	
	@JsonIgnore
	@OneToOne(mappedBy="contraint" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;
	
	public Contraint() {
		super();
	}

	public Contraint(int state, String description, byte[] documents, Date datecontraint, ContraintType type,
			Notice notice, User user) {
		super();
		this.state = state;
		this.description = description;
		this.documents = documents;
		this.datecontraint = datecontraint;
		this.type = type;
		//this.notice = notice;
		this.user = user;
	}
	
	
	
	public Contraint(Long idcontraint, int state, String description, byte[] documents, ContraintType type) {
		super();
		this.idcontraint = idcontraint;
		this.state = state;
		this.description = description;
		this.documents = documents;
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
/*
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	
*/
	public Long getIdcontraint() {
		return idcontraint;
	}

	public void setIdcontraint(Long idcontraint) {
		this.idcontraint = idcontraint;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public byte[] getDocuments() {
		return documents;
	}

	public void setDocuments(byte[] documents) {
		this.documents = documents;
	}
	
	

	public Date getDatecontraint() {
		return datecontraint;
	}

	public void setDatecontraint(Date datecontraint) {
		this.datecontraint = datecontraint;
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

	public Contraint(int state, String description , String reponse, byte[] documents, Date datecontraint, ContraintType type) {
		super();
		this.state = state;
		this.description = description;
		this.documents = documents;
		this.datecontraint = datecontraint;
		this.type = type;
		this.reponse = reponse ;
	}

	public Contraint(int state, String description, byte[] documents, ContraintType type) {
		super();
		this.state = state;
		this.description = description;
		this.documents = documents;
		
		this.type = type;
	}

	
	
	
	
	
	
	
	

}
