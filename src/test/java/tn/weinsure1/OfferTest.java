package tn.weinsure1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.weinsure1.entities.Offer;
import tn.weinsure1.service.IOfferService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferTest {

	@Autowired 
	IOfferService io;
	
	@Test		//Add Offer
	public void TestAddOffer() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-03-31");
		Offer o = new Offer();
		Offer OfferAdded = io.addOffer(o);
		Assert.assertEquals(o.getIdOffer(), OfferAdded.getIdOffer());
	} 
	
	@Test		//Update Offer
	public void TestUpdateOffer() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-04-01");
		Offer o = new Offer();
		Offer OfferUpdated = io.updateOffer(o);
		Assert.assertEquals(o.getExpiration_date(), OfferUpdated.getExpiration_date());
	}
	
	@Test		//Delete Offer
	public void TestDeleteOffer() {
		io.deleteOffer("30");
		}

	@Test		//Show all Offer
	public void TestRetriveAllOffers() {
		List<Offer> Offer = io.retrieveAllOffers() ;
		System.out.println(Offer);
	}
	
	@Test		//Show Offer
	public void TestRetriveOffer() {
		Offer offer = io.retrieveOffer("30");
		System.out.println(offer);
	}
}
