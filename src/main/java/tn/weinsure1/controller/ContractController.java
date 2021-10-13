package tn.weinsure1.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.ContractType;
import tn.weinsure1.entities.User;
import tn.weinsure1.service.IContractService;
import tn.weinsure1.service.IUserService;
import tn.weinsure1.service.IsinisterService;

@Scope(value="session")
@Controller(value="ContractController")
@ELBeanName(value="ContractController")
public class ContractController {

	
	@Autowired
	IContractService ic;
	IUserService iu;
	IsinisterService is;
	
	private List<Contract> contracts,rentecontracts,viecontracts;
	private boolean approved;
	private User user;
	private String fname,lname;
	private Date exp_date,cre_date;
	private int duration;
	private ContractType contracttype;
	private float price, cost;
	private double rate;
	private long userid, cntid, cntIdToBeUpdated;

	public List<User> getUsers(){
		return (ic.retrieveallusers());
	}
	
	public List<Contract> getContracts() {
		contracts = ic.RetrieveAllContracts();
		return contracts;
	}
	
	public List<Contract> getVieContracts(){
		viecontracts = ic.retrieveContractsbytype(ContractType.Vie);
		return viecontracts;
	}
	
	public List<Contract> getRenteContracts(){
		rentecontracts = ic.retrieveContractsbytype(ContractType.Rente);
		return rentecontracts;
	}
	
	public void setRentecontracts(List<Contract> rentecontracts) {
		this.rentecontracts = rentecontracts;
	}

	public void setViecontracts(List<Contract> viecontracts) {
		this.viecontracts = viecontracts;
	}

	public void addContract(){
		ic.addOrUpdateContract(new Contract(cre_date,exp_date,duration,price,contracttype,rate,approved,cost));
	
	}
	
	public void updateContract(){
		ic.addOrUpdateContract(new Contract(cntIdToBeUpdated,cre_date,exp_date,duration,price,contracttype,rate,approved,cost));
		ic.ContractToUser(cntIdToBeUpdated, userid);
	}
	
	public String addCapitalVieUniqueContract(){
		LocalDate exp = (new Date()).toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate().plusYears(duration);
		ic.addOrUpdateContract(new Contract(new Date(),Date.from(exp.atStartOfDay(ZoneId.systemDefault()).toInstant()),duration,ic.CapitalVieUnique(cost, userid, duration, rate),ContractType.Vie,rate,approved,cost));
		return "/contractvie?faces-redirect=true";
	}
	
	public void deleteContract(String cntid){
		ic.DeleteContract(Long.parseLong(cntid));
	}
	
	public void afficherContract(Contract cnt) {
		this.setApproved(cnt.isApproved());
		this.setCntid(cnt.getIdcontract());
		this.setContracttype(cnt.getType());
		this.setCre_date(cnt.getCreation_date());
		this.setExp_date(cnt.getExpiration_date());
		this.setDuration(cnt.getDuration());
		this.setPrice(cnt.getPrice());
		this.setCost(cnt.getCost());
		this.setRate(cnt.getRate());
		this.setCntIdToBeUpdated(cnt.getIdcontract());
		}
	
	public void affecterUsertoContract(){
		ic.ContractToUser(cntIdToBeUpdated, userid);
	}
	
	public String approveContract(Contract cnt){
		ic.ApproveContract(cnt.getIdcontract());
		return "/contractvie?faces-redirect=true";
	}
	
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public Date getCre_date() {
		return cre_date;
	}

	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ContractType[] getTypes(){
		return ContractType.values();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getCntid() {
		return cntid;
	}

	public void setCntid(long cntid) {
		this.cntid = cntid;
	}

	public long getCntIdToBeUpdated() {
		return cntIdToBeUpdated;
	}

	public void setCntIdToBeUpdated(long cntIdToBeUpdated) {
		this.cntIdToBeUpdated = cntIdToBeUpdated;
	}

	public ContractType getContracttype() {
		return contracttype;
	}

	public void setContracttype(ContractType contracttype) {
		this.contracttype = contracttype;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
