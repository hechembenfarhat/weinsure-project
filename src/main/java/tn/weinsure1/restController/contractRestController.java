package tn.weinsure1.restController;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.User;
import tn.weinsure1.service.IContractService;
import tn.weinsure1.service.IUserService;

@RestController
public class contractRestController {
/*
	@Autowired
	IContractService ic;
	IUserService iu;
	

	
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/retrieveAllContracts")
	  @ResponseBody
	  public List<Contract> getContract() {
		  List<Contract> c = ic.RetrieveAllContracts();
		  return c;
	  }
		

	  @GetMapping("/RertiveMyContract")
	  @ResponseBody
	  public List<Contract> RetrieveContractsByUserId() {
	  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  List<Contract> cnt = ic.RetrieveContractsByUserId(((User)principal).getId());
	  return cnt;
		}
	  
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/SinisterPerContractVie/{userid}")
	  @ResponseBody
	  public int SinisterPerContract(@PathVariable("userid")long id){
		 			return ic.SinistersPerContractVie(id);
	  }
	  
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/SinisterPerContractRente/{userid}")
	  @ResponseBody
	  public int SinisterPerContractRente(@PathVariable("userid")long id){
		 			return ic.SinistersPerContractRente(id);
	  }
	  
	  @PreAuthorize("hasRole('ROLE_ADMIN')") 
	  @DeleteMapping("/DeleteExpiredContracts")
	  @ResponseBody
	  public void DeleteExpiredContracts(){
		   ic.DeleteExpiredContracts();
	  }
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/DeleteContractsByUserId/{id}")
		@ResponseBody
		public void DeleteContractsByUserID(@PathVariable("id")long id){
			ic.DeleteContractsByUserId(id);
			
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/addContract")
		@ResponseBody	
		public Contract addContract(@RequestBody Contract c) {
			//{	"duration":"5",	"expiration_date":"",	"price":"",	"type":"",	"rate":""}
			c.setCreation_date(new Date());
			c.setDocument(null);
			return ic.AddContract(c);}
		
		@GetMapping("/findByDurationGreater/{Duration}")
		@ResponseBody
		public List<Contract> findByDurationGreater(@PathVariable("Duration") int Duration){
				List<Contract> c = ic.findByDurationGreater(Duration);		 
				  return c;
				  }	
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/ShowNotApprovedContracts")
		@ResponseBody
		public List<Contract> ShowNotApprovedContracts(){
				List<Contract> c = ic.ShowNotApprovedContracts();	 
				  return c;
				  }	
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping("/ApproveContract/{cntid}")
		@ResponseBody
		public void ApproveContract(@PathVariable("cntid")long cntid){
			ic.ApproveContract(cntid);			
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping("/ContractToUser/{idcnt}/{iduser}")
		@ResponseBody
		public void ContractToUser(@PathVariable("iduser")long iduser,@PathVariable("idcnt")long idcnt)
		{
		ic.ContractToUser(idcnt, iduser);
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/deletecontract/{idcontract}")
		@ResponseBody
		public void removeContract(@PathVariable("idcontract") Long idcontract) {
		   ic.DeleteContract(idcontract);
		   }
		
		@GetMapping(value="/CountContracts")
		@ResponseBody
		public int CountContracts(){
			return ic.CountContracts();
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/TotalPricing")
		@ResponseBody
		public float TotalPricing(){
			float total =0;
			total =ic.TotalPricing();
			return total;
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/TotalCost")
		@ResponseBody
		public float TotalCost(){
			float total =0;
			total =ic.TotalCost();
			return total;
		}

		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping(value = "/MAJcntprice/{cntid}/{price}") 
		@ResponseBody
		public void MAJContractPrice(@PathVariable("price")float price,@PathVariable("cntid")long cntid){
			ic.MAJContractPrice(price, cntid);
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping(value = "/MAJcntduration/{cntid}/{duration}") 
		@ResponseBody
	    public void MAJContractDuration(@PathVariable("duration")int duration, @PathVariable("cntid")long cntid){
			ic.MAJContractDuration(duration, cntid);
		}
		

		@PostMapping("/RITP/{p}")
		@ResponseBody  
		public double contractRITP(@PathVariable("p")double p)
		{	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return ic.RITP(p, ((User)principal).getId());
		}
		

		@PostMapping("/RITC/{c}")
		@ResponseBody  
		public double contractRITC(@PathVariable("c")double c)
		{	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return ic.RITC(c, ((User)principal).getId());
		}
		

		@PostMapping("/CVU/{C}/{duree}")
		@ResponseBody 
		public float CapitalVieUnique (@PathVariable("C")float C,@PathVariable("duree") int duree){
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return ic.CapitalVieUnique(C, ((User)principal).getId(), duree);
			
		}
		

		@PostMapping("/PVU/{prime}/{duree}")
		@ResponseBody 
		public float PrimeVieUnique(@PathVariable("prime")float prime, @PathVariable("duree")int duree){
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return ic.PrimeVieUnique(prime,  ((User)principal).getId(), duree);
		}		

		
		@PostMapping(value="/CapitalMixte/{prime}/{duree}")
		@ResponseBody
		public float CapitalMixte(@PathVariable("prime")double prime,@PathVariable("duree")int n){
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return ic.CapitalMixte(prime,  ((User)principal).getId(), n);
			}
		
*/
}