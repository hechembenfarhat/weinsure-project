
package tn.weinsure1.service;

import java.util.List;  

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.weinsure1.entities.TableMortalité;
import tn.weinsure1.entities.sinister;
import tn.weinsure1.repository.TableMortalitéRepository;

@Service
public class TableMortaliteService implements ITableMortaliteService {
	@Autowired
	TableMortalitéRepository tr ;

	private static final Logger L= LogManager.getLogger(TableMortaliteService.class);
	@Override
	public TableMortalité Addtm(TableMortalité t) {
		TableMortalité tm = tr.save(t);
		return tm;
	}
	@Override
	public float findBySurvivantsLx(int ageClient){
		float k  = tr.findBySurvivantsLx(ageClient);
		L.info("tm +++ :" + k) ;
		return k;
		
	}
	@Override
	public float findByDecesDx(int deces){
		float k  = tr.findByDecesDx(deces);
		L.info("tm +++ :" + k) ;
		return k;
		
	}
	
	
	@Override
	public float calcull(float capital , int ageClient, int AgeMax, double taux){
		int k;
		float prime = 0;
		double v= 0 ;
		float dxk = 0 ;
		float lx = 0 ;
		for (k =0; k < AgeMax - ageClient; k++) {
			 dxk= tr.findByDecesDx(ageClient+k); 	
			L.info("DX " + dxk) ;
			lx = tr.findBySurvivantsLx(ageClient);
			  v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );			 
				
	}
		prime = (float) (capital * v) *  ( dxk / lx) ;
		L.info("PRIME+++++++++ =" + prime) ;
		return prime;
	}
	
	public float findProbaByAgeClient(int ageClient) {
		float k  = tr.findProbaByAgeClient(ageClient);
		L.info("tm +++ :" + k) ;
		return k;
		
	}
	public int findAgeMax(){
		int k = tr.findAgeMax();
		return k;
		
	}
	
	
	
}
