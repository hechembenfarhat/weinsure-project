package tn.weinsure1.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Notice")
public class Notice implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IDNotice")
	private Long idnotice;
	
	@Column(name="State")
	private int note;
	
	@Column(name="Description")
	private String description;
	
	@ManyToOne
	User user;
	
/*
	@JsonIgnore
	@OneToOne(mappedBy="notice")
	private Contraint contraint ;
	
	public Contraint getContraint() {
		return contraint;
	}

	public void setContraint(Contraint contraint) {
		this.contraint = contraint;
	}
*/
	public Long getIdnotice() {
		return idnotice;
	}

	public void setIdnotice(Long idnotice) {
		this.idnotice = idnotice;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Notice(int note, String description) {
		super();
		this.note = note;
		this.description = description;
	}
 
	public Notice() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
