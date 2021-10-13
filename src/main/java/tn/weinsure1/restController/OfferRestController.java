package tn.weinsure1.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Offer;
import tn.weinsure1.entities.User;
import tn.weinsure1.service.IOfferService;

@RestController
public class OfferRestController {
	
	@Autowired
	IOfferService io;
	
	@PostMapping("/addOffer")
	@ResponseBody	
	public Offer addOffer(@RequestBody Offer o) {
	return io.addOffer(o);}
	
	@GetMapping("/retrieveAllOffers")
	@ResponseBody
	public List<Offer> getOffer() {
	 List<Offer> o = io.retrieveAllOffers();
	 return o;
	 }
	
	@PostMapping("/affOfferUser/{idUser}/{idOffer}")
	  public void affecterUseraOffer(@PathVariable("idUser")Long iduser,@PathVariable("idOffer")Long idoffer) {
	  io.affecterUserOffer(iduser, idoffer);
	  }
	
	@GetMapping("/olduser")
	@ResponseBody
	public Long OldUser() {
	 Long o = io.Old_User1();
	 return o;
	 }
	
	@GetMapping("/pack3")
	@ResponseBody
	public List<Long> pack3() {
	 List<Long> o = io.pack_3();
	 return o;
	 }
	
	@GetMapping("/pack2")
	@ResponseBody
	public List<Long> pack2() {
	 List<Long> o = io.pack_2();
	 return o;
	 }
	
	@GetMapping("/pack1")
	@ResponseBody
	public List<Long> pack1() {
	 List<Long> o = io.pack_1();
	 return o;
	 }
	
	@GetMapping("/test")
	@ResponseBody
	public Long test2() {
	 Long o = io.test1();
	 return o;
	 }
	
	@GetMapping("/topnum")
	@ResponseBody
	public Long topnum() {
	 Long o = io.topnum();
	 return o;
	 }
	
	@GetMapping("/topusers")
	@ResponseBody
	public List<Long> topusers() {
	 List<Long> o = io.Top_Users(io.topnum());
	 return o;
	 }
}
