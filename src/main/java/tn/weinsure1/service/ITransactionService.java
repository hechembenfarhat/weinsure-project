package tn.weinsure1.service;


import java.util.List;
import java.util.Optional;

import tn.weinsure1.entities.Transaction;



public interface ITransactionService {

	Transaction addTransaction(Transaction t);

	void deleteTransaction(int id);

	List<Transaction> retrieveAllTransactions();

	Transaction retrieveTransactions(int id);

	  List<Transaction> listAll();

}