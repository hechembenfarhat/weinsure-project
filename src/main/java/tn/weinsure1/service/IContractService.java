package tn.weinsure1.service;


import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.ContractType;
import tn.weinsure1.entities.User;

public interface IContractService {

	List<Contract> RetrieveAllContracts(); 
	Contract AddContract(Contract c);
	void DeleteContract(Long id);
	Contract UpdateContract(Contract c);
	Contract RetrieveContract(String id);
	List<Contract> findByDurationGreater(int year);
	List<Contract> ShowNotApprovedContracts();
	void ContractToUser(long cntID, long userID);
	float TotalPricing();
	List<Contract> RetrieveContractsByUserId(long id);
	float PrimeVieUnique(float prime, long userid, int duree);
	double RITP(double prime,long userid);
	double RITC(double d,long userid);
	void MAJContractPrice(float price,long cntid);
	float CapitalMixte(double prime,long userid,int n);
	void DeleteContractsByUserId(long id);
	int CountContracts();
	void MAJContractDuration(int duration,long cntid);
	int SinistersPerContractVie (long id);
	int SinistersPerContractRente(long id);
	int CountContractsByIdAndType(long id, ContractType type);
	void DeleteExpiredContracts();
	void ApproveContract(long cntid);
	float TotalCost();
	long addOrUpdateContract(Contract contract);
	List<Contract> retrieveContractsbytype(ContractType type);
	List<User> retrieveallusers();
	float CapitalVieUnique(float C, long userid, int duree,double taux);

}