package tn.weinsure1.service;

import java.util.List;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Offer;
import tn.weinsure1.entities.User;

public interface IOfferService {

	List<Offer> retrieveAllOffers(); 
	 Offer addOffer(Offer O);
	 void deleteOffer(String id);
	 Offer updateOffer(Offer O);
	 Offer retrieveOffer(String id);
	void affecterUserOffer(long UserId,long OfferId);
	Long Old_User1(); 
	Long test1();
	Long topnum();
	List<Long> pack_3();
	List<Long> pack_2();
	List<Long> pack_1();
	List<Long> Top_Users(Long topnum);


}
