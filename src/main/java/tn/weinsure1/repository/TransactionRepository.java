package tn.weinsure1.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.weinsure1.entities.Transaction;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

	
}