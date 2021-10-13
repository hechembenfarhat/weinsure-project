package tn.weinsure1.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Offer")
public class Offer implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IDOffer")
	private Long IdOffer;
	@Column (name="Type")
	private String Type;
	@Column(name="Expiration_Date")
	private Date Expiration_date;
	@Column(name="Description")
	private String Description;
	@Column(name="Prix")
	private int Prix;
	public Long getIdOffer() {
		return IdOffer;
	}
	public void setIdOffer(Long idOffer) {
		IdOffer = idOffer;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getExpiration_date() {
		return Expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		Expiration_date = expiration_date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}

	@ManyToMany
	@JoinTable(
	  name = "Offer_User", 
	  joinColumns = @JoinColumn(name = "IdOffer"), 
	  inverseJoinColumns = @JoinColumn(name = "IdUser"))
	List<User> users;
	
	public Offer(Long idOffer, String type, Date expiration_date, String description, int prix) {
		super();
		IdOffer = idOffer;
		Type = type;
		Expiration_date = expiration_date;
		Description = description;
		Prix = prix;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * 
	 */
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
//test