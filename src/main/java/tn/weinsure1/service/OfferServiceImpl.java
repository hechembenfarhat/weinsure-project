package tn.weinsure1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Offer;
import tn.weinsure1.entities.User;
import tn.weinsure1.repository.OfferRepository;
import tn.weinsure1.repository.UserRepository;


@Service
public class OfferServiceImpl implements IOfferService {

	@Autowired     
	OfferRepository OfferRepository ;
	UserRepository userRepository;
	private static final Logger L = LogManager.getLogger(OfferServiceImpl.class);

	@Override
	public Offer addOffer (Offer O) {
		Offer OfferSaved = null;
		OfferSaved = OfferRepository.save(O);
		
		return OfferSaved;
	
	}
	@Override
	public void deleteOffer(String id) {
		OfferRepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public Offer updateOffer(Offer O) {
		Offer OfferAdded = OfferRepository.save(O);
		return OfferAdded;
	}
	
	@Override
	public Offer retrieveOffer(String id) {
		L.info("in retrieveOffer id = " + id);
		Offer O = OfferRepository.findById(Long.parseLong(id)).get();
		L.info("Offer returned = : " + O);
		return O;
			}
	
	
	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> Offers = (List<Offer>) OfferRepository.findAll(); 
		for(Offer ofr : Offers)
		{
			L.info("Offer +++ :" + ofr);
		}
					
		return Offers;
	}
	@Override
	public void affecterUserOffer(long UserId, long OfferId) {
	Offer offer = OfferRepository.findById(OfferId).get();
	User user = userRepository.findById(UserId).get();
	
	if(offer.getUsers() == null){
		List<User> users = new ArrayList<>();
		users.add(user);
		offer.setUsers(users);
		}
	else{
		offer.getUsers().add(user);
	}
	}	
	@Override
	public Long Old_User1() {
		List<Long> l = (List<Long>) OfferRepository.Old_User(); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);
		}
					
		return l.get(0);	
	}
	
	@Override
	public Long topnum() {
		List<Long> l = (List<Long>) OfferRepository.Top_num_Contracts(); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);

		}
					
		return l.get(0);	
	}
	@Override
	public Long test1() {
		List<Long> l = (List<Long>) OfferRepository.Top_num_Contracts(); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);

		}
					
		return l.get(0);	
	}
	
	@Override
	public List<Long> pack_3() {
		List<Long> l = (List<Long>) OfferRepository.Users_pack3(); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);
		}
					
		return l;	
	}
	
	@Override
	public List<Long> pack_2() {
		List<Long> l = (List<Long>) OfferRepository.Users_pack2(); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);
		}
					
		return l;	
	}
	
	@Override
	public List<Long> pack_1() {
		List<Long> l = (List<Long>) OfferRepository.Users_pack1(); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);
		}
					
		return l;	
	}
	
	@Override
	public List<Long> Top_Users(Long num) {
		List<Long> l = (List<Long>) OfferRepository.Top_Users(num); 
		for(Long ls : l)
		{
			L.info("Offer +++ :" + ls);

		}
					
		return l;	
	}
	
}
