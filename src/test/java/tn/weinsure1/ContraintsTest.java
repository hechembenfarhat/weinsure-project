package tn.weinsure1;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.weinsure1.entities.Contraint;
import tn.weinsure1.entities.ContraintType;
import tn.weinsure1.service.IContractService;
import tn.weinsure1.service.IContraintService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContraintsTest {

	@Autowired 
	IContraintService ic;
/*	@Test		//Add Contraint
	public void TestAddContraint() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-01-01");
		Date d2 = new Date(); 
		File documents;
		Contraint c = new Contraint (1,"description",null,d2,ContraintType.feedback);
		Contraint ContraintAdded = ic.AddContraint(c);
		Assert.assertEquals(c.getIdcontraint(), ContraintAdded.getIdcontraint());
	} 
	
	
	*/
	 
}
