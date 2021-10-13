package tn.weinsure1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.weinsure1.entities.ContractType;
import tn.weinsure1.entities.TableMortalité;
import tn.weinsure1.service.IContractService;
import tn.weinsure1.service.ITableMortaliteService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractsTest {

	@Autowired 
	IContractService ic;
	@Autowired
	ITableMortaliteService tr;
	/*
	@Test		//Add Contract
	public void TestAddContract() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2025-01-01");
		Contract c = new Contract(d,ic.CapitalVieUnique(5000,40,13,5),ContractType.Décès,null);
		c.setCreation_date(new Date());
		LocalDate crdate = c.getCreation_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate expdate = c.getExpiration_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		c.setDuration(expdate.getYear()-crdate.getYear());
		Contract ContractAdded = ic.AddContract(c);
		Assert.assertEquals(c.getIdcontract(), ContractAdded.getIdcontract());
	} 
	/*
	@Test		//Update Contract
	public void TestUpdateContract() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = new Date();
		Contract cnt = new Contract (2L, d,d,3,125,ContractType.Dommages, null );
		Contract ContractUpdated = ic.UpdateContract(cnt);
		Assert.assertEquals(cnt.getIdcontract(), ContractUpdated.getIdcontract());
	}
	
	@Test		//Delete Contract 
	public void TestDeleteContract() {
				ic.DeleteContract("7"); 
		}

	@Test		//Show all contracts
	public void TestRetriveAllContracts() {
		List<Contract> contracts = ic.RetrieveAllContracts() ;
		System.out.println(contracts);
	}
	
	@Test		//Show contract 
	public void TestRetriveContract() {
		Contract contract = ic.RetrieveContract("1");
		System.out.println(contract);
	}
	*/
	/*@Test
	public void testfindByYear() {

		List<Contract> cnt = ic.findByDurationGreater(2) ;
		System.out.println(cnt);
	} */
/*
	@Test
	public void testcalcul (){
		float cnt = ic.PrimeVieUnique(2690, 1L, 5);
		System.out.println(cnt);	
	}*/
	//Test Affectation User to contract
	/*@Test
	public void contractuser(){
		ic.ContractToUser(1,1);
	}*//*
	@Test
	public void testest(){
		TableMortalité t0=new TableMortalité(100000,100000,1,1f);	TableMortalité tm0=tr.Addtm(t0);
		TableMortalité t1=new TableMortalité(97104,97660,2,0.99431f);	TableMortalité tm1=tr.Addtm(t1);
		TableMortalité t2=new TableMortalité(96869,97436,3,0.99418f);	TableMortalité tm2=tr.Addtm(t2);
		TableMortalité t3=new TableMortalité(96727,97311,4,0.994f);	TableMortalité tm3=tr.Addtm(t3);
		TableMortalité t4=new TableMortalité(96624,97223,5,0.99384f);	TableMortalité tm4=tr.Addtm(t4);
		TableMortalité t5=new TableMortalité(96541,97156,6,0.99367f);	TableMortalité tm5=tr.Addtm(t5);
		TableMortalité t6=new TableMortalité(96471,97100,7,0.99352f);	TableMortalité tm6=tr.Addtm(t6);
		TableMortalité t7=new TableMortalité(96410,97051,8,0.9934f);	TableMortalité tm7=tr.Addtm(t7);
		TableMortalité t8=new TableMortalité(96356,97006,9,0.9933f);	TableMortalité tm8=tr.Addtm(t8);
		TableMortalité t9=new TableMortalité(96306,96964,10,0.99321f);	TableMortalité tm9=tr.Addtm(t9);
		TableMortalité t10=new TableMortalité(96258,96923,11,0.99314f);	TableMortalité tm10=tr.Addtm(t10);
		TableMortalité t11=new TableMortalité(96211,96883,12,0.99306f);	TableMortalité tm11=tr.Addtm(t11);
		TableMortalité t12=new TableMortalité(96163,96842,13,0.99299f);	TableMortalité tm12=tr.Addtm(t12);
		TableMortalité t13=new TableMortalité(96111,96800,14,0.99288f);	TableMortalité tm13=tr.Addtm(t13);
		TableMortalité t14=new TableMortalité(96052,96758,15,0.9927f);	TableMortalité tm14=tr.Addtm(t14);
		TableMortalité t15=new TableMortalité(95985,96713,16,0.99247f);	TableMortalité tm15=tr.Addtm(t15);
		TableMortalité t16=new TableMortalité(95908,96667,17,0.99215f);	TableMortalité tm16=tr.Addtm(t16);
		TableMortalité t17=new TableMortalité(95821,96619,18,0.99174f);	TableMortalité tm17=tr.Addtm(t17);
		TableMortalité t18=new TableMortalité(95722,96569,19,0.99123f);	TableMortalité tm18=tr.Addtm(t18);
		TableMortalité t19=new TableMortalité(95614,96517,20,0.99064f);	TableMortalité tm19=tr.Addtm(t19);
		TableMortalité t20=new TableMortalité(95496,96462,21,0.98999f);	TableMortalité tm20=tr.Addtm(t20);
		TableMortalité t21=new TableMortalité(95372,96405,22,0.98928f);	TableMortalité tm21=tr.Addtm(t21);
		TableMortalité t22=new TableMortalité(95242,96346,23,0.98854f);	TableMortalité tm22=tr.Addtm(t22);
		TableMortalité t23=new TableMortalité(95108,96284,24,0.98779f);	TableMortalité tm23=tr.Addtm(t23);
		TableMortalité t24=new TableMortalité(94971,96219,25,0.98703f);	TableMortalité tm24=tr.Addtm(t24);
		TableMortalité t25=new TableMortalité(94834,96151,26,0.9863f);	TableMortalité tm25=tr.Addtm(t25);
		TableMortalité t26=new TableMortalité(94696,96080,27,0.9856f);	TableMortalité tm26=tr.Addtm(t26);
		TableMortalité t27=new TableMortalité(94558,96006,28,0.98492f);	TableMortalité tm27=tr.Addtm(t27);
		TableMortalité t28=new TableMortalité(94420,95929,29,0.98427f);	TableMortalité tm28=tr.Addtm(t28);
		TableMortalité t29=new TableMortalité(94283,95849,30,0.98366f);	TableMortalité tm29=tr.Addtm(t29);
		TableMortalité t30=new TableMortalité(94145,95765,31,0.98308f);	TableMortalité tm30=tr.Addtm(t30);
		TableMortalité t31=new TableMortalité(94007,95677,32,0.98255f);	TableMortalité tm31=tr.Addtm(t31);
		TableMortalité t32=new TableMortalité(93867,95585,33,0.98203f);	TableMortalité tm32=tr.Addtm(t32);
		TableMortalité t33=new TableMortalité(93724,95488,34,0.98153f);	TableMortalité tm33=tr.Addtm(t33);
		TableMortalité t34=new TableMortalité(93578,95387,35,0.98104f);	TableMortalité tm34=tr.Addtm(t34);
		TableMortalité t35=new TableMortalité(93426,95281,36,0.98053f);	TableMortalité tm35=tr.Addtm(t35);
		TableMortalité t36=new TableMortalité(93268,95170,37,0.98001f);	TableMortalité tm36=tr.Addtm(t36);
		TableMortalité t37=new TableMortalité(93102,95052,38,0.97948f);	TableMortalité tm37=tr.Addtm(t37);
		TableMortalité t38=new TableMortalité(92926,94928,39,0.97891f);	TableMortalité tm38=tr.Addtm(t38);
		TableMortalité t39=new TableMortalité(92739,94796,40,0.9783f);	TableMortalité tm39=tr.Addtm(t39);
		TableMortalité t40=new TableMortalité(92538,94656,41,0.97762f);	TableMortalité tm40=tr.Addtm(t40);
		TableMortalité t41=new TableMortalité(92323,94508,42,0.97688f);	TableMortalité tm41=tr.Addtm(t41);
		TableMortalité t42=new TableMortalité(92089,94350,43,0.97604f);	TableMortalité tm42=tr.Addtm(t42);
		TableMortalité t43=new TableMortalité(91837,94180,44,0.97512f);	TableMortalité tm43=tr.Addtm(t43);
		TableMortalité t44=new TableMortalité(91562,93999,45,0.97407f);	TableMortalité tm44=tr.Addtm(t44);
		TableMortalité t45=new TableMortalité(91263,93804,46,0.97291f);	TableMortalité tm45=tr.Addtm(t45);
		TableMortalité t46=new TableMortalité(90937,93594,47,0.97161f);	TableMortalité tm46=tr.Addtm(t46);
		TableMortalité t47=new TableMortalité(90580,93367,48,0.97015f);	TableMortalité tm47=tr.Addtm(t47);
		TableMortalité t48=new TableMortalité(90190,93121,49,0.96852f);	TableMortalité tm48=tr.Addtm(t48);
		TableMortalité t49=new TableMortalité(89764,92854,50,0.96672f);	TableMortalité tm49=tr.Addtm(t49);
		TableMortalité t50=new TableMortalité(89297,92564,51,0.96471f);	TableMortalité tm50=tr.Addtm(t50);
		TableMortalité t51=new TableMortalité(88786,92247,52,0.96248f);	TableMortalité tm51=tr.Addtm(t51);
		TableMortalité t52=new TableMortalité(88226,91901,53,0.96001f);	TableMortalité tm52=tr.Addtm(t52);
		TableMortalité t53=new TableMortalité(87614,91523,54,0.95729f);	TableMortalité tm53=tr.Addtm(t53);
		TableMortalité t54=new TableMortalité(86944,91108,55,0.9543f);	TableMortalité tm54=tr.Addtm(t54);
		TableMortalité t55=new TableMortalité(86211,90651,56,0.95102f);	TableMortalité tm55=tr.Addtm(t55);
		TableMortalité t56=new TableMortalité(85410,90150,57,0.94742f);	TableMortalité tm56=tr.Addtm(t56);
		TableMortalité t57=new TableMortalité(84536,89597,58,0.94351f);	TableMortalité tm57=tr.Addtm(t57);
		TableMortalité t58=new TableMortalité(83582,88988,59,0.93925f);	TableMortalité tm58=tr.Addtm(t58);
		TableMortalité t59=new TableMortalité(82542,88317,60,0.93461f);	TableMortalité tm59=tr.Addtm(t59);
		TableMortalité t60=new TableMortalité(81409,87576,61,0.92958f);	TableMortalité tm60=tr.Addtm(t60);
		TableMortalité t61=new TableMortalité(80178,86757,62,0.92417f);	TableMortalité tm61=tr.Addtm(t61);
		TableMortalité t62=new TableMortalité(78842,85853,63,0.91834f);	TableMortalité tm62=tr.Addtm(t62);
		TableMortalité t63=new TableMortalité(77393,84856,64,0.91205f);	TableMortalité tm63=tr.Addtm(t63);
		TableMortalité t64=new TableMortalité(75826,83754,65,0.90534f);	TableMortalité tm64=tr.Addtm(t64);
		TableMortalité t65=new TableMortalité(74134,82540,66,0.89816f);	TableMortalité tm65=tr.Addtm(t65);
		TableMortalité t66=new TableMortalité(72312,81202,67,0.89052f);	TableMortalité tm66=tr.Addtm(t66);
		TableMortalité t67=new TableMortalité(70354,79729,68,0.88241f);	TableMortalité tm67=tr.Addtm(t67);
		TableMortalité t68=new TableMortalité(68257,78111,69,0.87385f);	TableMortalité tm68=tr.Addtm(t68);
		TableMortalité t69=new TableMortalité(66017,76337,70,0.86481f);	TableMortalité tm69=tr.Addtm(t69);
		TableMortalité t70=new TableMortalité(63632,74395,71,0.85533f);	TableMortalité tm70=tr.Addtm(t70);
		TableMortalité t71=new TableMortalité(61103,72275,72,0.84542f);	TableMortalité tm71=tr.Addtm(t71);
		TableMortalité t72=new TableMortalité(58432,69969,73,0.83511f);	TableMortalité tm72=tr.Addtm(t72);
		TableMortalité t73=new TableMortalité(55623,67469,74,0.82442f);	TableMortalité tm73=tr.Addtm(t73);
		TableMortalité t74=new TableMortalité(52686,64770,75,0.81343f);	TableMortalité tm74=tr.Addtm(t74);
		TableMortalité t75=new TableMortalité(49629,61869,76,0.80216f);	TableMortalité tm75=tr.Addtm(t75);
		TableMortalité t76=new TableMortalité(46469,58769,77,0.79071f);	TableMortalité tm76=tr.Addtm(t76);
		TableMortalité t77=new TableMortalité(43222,55474,78,0.77914f);	TableMortalité tm77=tr.Addtm(t77);
		TableMortalité t78=new TableMortalité(39911,51997,79,0.76756f);	TableMortalité tm78=tr.Addtm(t78);
		TableMortalité t79=new TableMortalité(36560,48356,80,0.75606f);	TableMortalité tm79=tr.Addtm(t79);
		TableMortalité t80=new TableMortalité(33200,44576,81,0.7448f);	TableMortalité tm80=tr.Addtm(t80);
		TableMortalité t81=new TableMortalité(29861,40689,82,0.73388f);	TableMortalité tm81=tr.Addtm(t81);
		TableMortalité t82=new TableMortalité(26580,36735,83,0.72356f);	TableMortalité tm82=tr.Addtm(t82);
		TableMortalité t83=new TableMortalité(23390,32762,84,0.71394f);	TableMortalité tm83=tr.Addtm(t83);
		TableMortalité t84=new TableMortalité(20328,28823,85,0.70527f);	TableMortalité tm84=tr.Addtm(t84);
		TableMortalité t85=new TableMortalité(17428,24976,86,0.69779f);	TableMortalité tm85=tr.Addtm(t85);
		TableMortalité t86=new TableMortalité(14722,21282,87,0.69176f);	TableMortalité tm86=tr.Addtm(t86);
		TableMortalité t87=new TableMortalité(12238,17799,88,0.68757f);	TableMortalité tm87=tr.Addtm(t87);
		TableMortalité t88=new TableMortalité(9997,14583,89,0.68552f);	TableMortalité tm88=tr.Addtm(t88);
		TableMortalité t89=new TableMortalité(8013,11679,90,0.6861f);	TableMortalité tm89=tr.Addtm(t89);
		TableMortalité t90=new TableMortalité(6292,9122,91,0.68976f);	TableMortalité tm90=tr.Addtm(t90);
		TableMortalité t91=new TableMortalité(4832,6931,92,0.69716f);	TableMortalité tm91=tr.Addtm(t91);
		TableMortalité t92=new TableMortalité(3623,5110,93,0.709f);	TableMortalité tm92=tr.Addtm(t92);
		TableMortalité t93=new TableMortalité(2647,3645,94,0.7262f);	TableMortalité tm93=tr.Addtm(t93);
		TableMortalité t94=new TableMortalité(1876,2498,95,0.751f);	TableMortalité tm94=tr.Addtm(t94);
		TableMortalité t95=new TableMortalité(1286,1637,96,0.78558f);	TableMortalité tm95=tr.Addtm(t95);
		TableMortalité t96=new TableMortalité(850,1019,97,0.83415f);	TableMortalité tm96=tr.Addtm(t96);
		TableMortalité t97=new TableMortalité(539,597,98,0.90285f);	TableMortalité tm97=tr.Addtm(t97);
		TableMortalité t98=new TableMortalité(326,326,99,1f);	TableMortalité tm98=tr.Addtm(t98);
		TableMortalité t99=new TableMortalité(187,164,100,1.14024f);	TableMortalité tm99=tr.Addtm(t99);
		TableMortalité t100=new TableMortalité(101,75,101,1.34667f);	TableMortalité tm100=tr.Addtm(t100);
		TableMortalité t101=new TableMortalité(51,30,102,1.7f);	TableMortalité tm101=tr.Addtm(t101);
		TableMortalité t102=new TableMortalité(24,10,103,2.4f);	TableMortalité tm102=tr.Addtm(t102);
		TableMortalité t103=new TableMortalité(10,3,104,3.33333f);	TableMortalité tm103=tr.Addtm(t103);
		TableMortalité t104=new TableMortalité(4,1,105,4f);	TableMortalité tm104=tr.Addtm(t104);
		TableMortalité t105=new TableMortalité(1,0,106,0f);	TableMortalité tm105=tr.Addtm(t105);
		TableMortalité t106=new TableMortalité(0,0,107,0f);	TableMortalité tm106=tr.Addtm(t106);
		TableMortalité t107=new TableMortalité(0,0,108,0f);	TableMortalité tm107=tr.Addtm(t107);
		TableMortalité t108=new TableMortalité(0,0,109,0f);	TableMortalité tm108=tr.Addtm(t108);
		TableMortalité t109=new TableMortalité(0,0,110,0f);	TableMortalité tm109=tr.Addtm(t109);
		TableMortalité t110=new TableMortalité(0,0,111,0f);	TableMortalité tm110=tr.Addtm(t110);
		TableMortalité t111=new TableMortalité(0,0,112,0f);	TableMortalité tm111=tr.Addtm(t111);
		TableMortalité t112=new TableMortalité(0,0,113,0f);	TableMortalité tm112=tr.Addtm(t112);
		TableMortalité t113=new TableMortalité(0,0,114,0f);	TableMortalité tm113=tr.Addtm(t113);
		TableMortalité t114=new TableMortalité(0,0,115,0f);	TableMortalité tm114=tr.Addtm(t114);
		TableMortalité t115=new TableMortalité(0,0,116,0f);	TableMortalité tm115=tr.Addtm(t115);
		TableMortalité t116=new TableMortalité(0,0,117,0f);	TableMortalité tm116=tr.Addtm(t116);
		TableMortalité t117=new TableMortalité(0,0,118,0f);	TableMortalité tm117=tr.Addtm(t117);
		TableMortalité t118=new TableMortalité(0,0,119,0f);	TableMortalité tm118=tr.Addtm(t118);
		TableMortalité t119=new TableMortalité(0,0,120,0f);	TableMortalité tm119=tr.Addtm(t119);
		}*/
	/*@Test
	public void testest(){
		List <Contract> cnt = ic.RetrieveContractsByUserId(2L);
			}*/
}
