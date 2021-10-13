package tn.weinsure1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Role;
import tn.weinsure1.entities.User;
import tn.weinsure1.entities.sinister;
import tn.weinsure1.entities.sinisterstatus;
import tn.weinsure1.repository.UserRepository;


@Service
public class UserServiceImpl implements IUserService { 
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger L= LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> RetrieveAllUsers(){
		List<User>users= ( List <User>) userRepository.findAll();
	
		for (User user : users){
			L.info("user +++ :" + user);
		} 
		return users;
	}
	@Override
	public User AddUser(User u) {
		User us = userRepository.save(u);
		return us;
	}
	
	
	@Override
	public void DeleteUser(String id) {
	userRepository.deleteById(Long.parseLong(id));
	}


	@Override
	public User UpdateUser(User u) {
		// TODO Auto-generated method stub
		User UserUpdated = userRepository.save(u);
		return UserUpdated;
	
	}

	@Override
	public User RetrieveUser(String id) {
		L.info("in RetrieveUser id = " + id);
		User u = userRepository.findById(Long.parseLong(id)).get();
		L.info("Usert returned = : " + u);
		return u;	
	}
	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}


	/*
	@Override
	public List<User> findByRole(Role ro) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> findByDescription(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> findByYear(String year) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> findByAny(String any) {
		// TODO Auto-generated method stub
		return null;
	}}
	/*
	@Override 
	public List<User> findByRole(Role ro) {
		return userRepository.findUserByRole(ro);
	}
	}

	@Override
	public List<sinister> findByDescription(String name) {

		List<sinister> sins = sinistreRepository.findByDescription(name);
		L.info("sinister +++ :" + sins) ;
		return sins;
	} 

	@Override
	public List<sinister> findByYear(String year) {
		List<sinister> sins = sinistreRepository.findByYear(year);
		L.info("sinistre +++ :" + sins) ;
		return sins;
	}
	@Override
	public List<sinister> findByAny(String any) {
		List<sinister> sins = sinistreRepository.findByAny(any);
		L.info("sinistre +++ :" + sins) ;
		return sins;
	}
	
	}*/