package tn.weinsure1.entities;


import java.io.File;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;




@SuppressWarnings("serial")
@Entity
@Table(name="Contract")
public class Contract implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IDContract")
	private Long idcontract;
	@Temporal(TemporalType.DATE)
	@Column(name="Creation_Date")
	private Date Creation_date;
	@Temporal(TemporalType.DATE)
	@Column(name="Expiration_Date")
	private Date Expiration_date;
	@Column(name="Duration")
	private int Duration;
	@Column(name="Price")
	private float Price;
	@Enumerated(EnumType.STRING)
	@Column (name="Type")
	ContractType Type;
	@Column(name="Rate")
	private double rate;
	@Column(name="Document")
	private File Document;
	@Column(name="Approved",columnDefinition = "boolean default false")
	private boolean approved;
	@Column(name="Cost")
	private float cost;
	

	public Contract(Date creation_date, Date expiration_date, int duration, float price,
			ContractType type, double rate, boolean approved, float cost) {
		this.Creation_date = creation_date;
		this.Expiration_date = expiration_date;
		this.Duration = duration;
		this.Price = price;
		this.Type = type;
		this.rate = rate;
		this.approved = approved;
		this.cost = cost;
	}
	public Contract(Date creation_date, Date expiration_date, int duration, float price,
			ContractType type, double rate, boolean approved, float cost,User user) {
		this.Creation_date = creation_date;
		this.Expiration_date = expiration_date;
		this.Duration = duration;
		this.Price = price;
		this.Type = type;
		this.rate = rate;
		this.approved = approved;
		this.cost = cost;
		this.user=user;
	}
	
	public Contract(Long idcontract, Date creation_date, Date expiration_date, int duration, float price,
			ContractType type, double rate, boolean approved, float cost) {
		this.idcontract = idcontract;
		this.Creation_date = creation_date;
		this.Expiration_date = expiration_date;
		this.Duration = duration;
		this.Price = price;
		this.Type = type;
		this.rate = rate;
		this.approved = approved;
		this.cost = cost;
	}

	public Contract(Long idcontract, Date creation_date, Date expiration_date, int duration, float price,
			ContractType type, double rate, boolean approved, float cost,User user) {
		this.idcontract = idcontract;
		this.Creation_date = creation_date;
		this.Expiration_date = expiration_date;
		this.Duration = duration;
		this.Price = price;
		this.Type = type;
		this.rate = rate;
		this.approved = approved;
		this.cost = cost;
	}
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public List<Transaction> getTransactionCredit() {
		return transactionCredit;
	}
	public void setTransactionCredit(List<Transaction> transactionCredit) {
		this.transactionCredit = transactionCredit;
	}
	public Long getIdcontract() {
		return idcontract;
	}
	public void setIdcontract(Long idcontract) {
		this.idcontract = idcontract;
	}
	public Date getCreation_date() {
		return Creation_date;
	}
	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}
	public Date getExpiration_date() {
		return Expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		Expiration_date = expiration_date;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public ContractType getType() {
		return Type;
	}
	public void setType(ContractType type) {
		Type = type;
	}
	public File getDocument() {
		return Document;
	}
	public void setDocument(File document) {
		Document = document;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "USER_ID",referencedColumnName="USER_ID")
	 private User user;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="transactionprice")
	private List<Transaction> transactionCredit;
	 

	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Contract [idcontract=" + idcontract + ", Creation_date=" + Creation_date + ", Expiration_date="
				+ Expiration_date + ", Duration=" + Duration + ", Price=" + Price + ", Type=" + Type + ", Document="
				+ Document + "]";
	}
	
	
	public Contract() {
		super();
		
	}
	public Contract(Date expiration_date, float price, ContractType type, File document) {
		this.Expiration_date = expiration_date;
		this.Price = price;
		this.Type = type;
		this.Document = document;
	}

	
}
