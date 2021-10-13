package tn.weinsure1.entities;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transactionID")
	private int transactionid;
	
	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	private float transactionAmount;
	
	@Enumerated(EnumType.STRING)
	private TransType transactionType;
	
	
	
    @ManyToOne
    @JoinColumn(name = "idcontract",referencedColumnName="IDContract")
	@JsonIgnore
    private Contract transactionprice;

    private int nbreC;
    private float amountC;
    
    
	public int getNbreC() {
		return nbreC;
	}

	public void setNbreC(int nbreC) {
		this.nbreC = nbreC;
	}

	public float getAmountC() {
		return amountC;
	}

	public void setAmountC(float amountC) {
		this.amountC = amountC;
	}



	public Transaction(Date transaction_date, float transaction_amount, TransType transaction_type) {
		super();
		this.transactionDate = transaction_date;
		this.transactionAmount = transaction_amount;
		this.transactionType = transaction_type;
	}
	

	public Transaction() {
		super();
	}

	

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransType transactionType) {
		this.transactionType = transactionType;
	}

	public Contract getTransactionprice() {
		return transactionprice;
	}

	public void setTransactionprice(Contract transactionprice) {
		this.transactionprice = transactionprice;
	}




	
}
