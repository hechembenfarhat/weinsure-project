package tn.weinsure1;


import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.TableMortalité;
import tn.weinsure1.entities.User;
import tn.weinsure1.entities.sinister;
import tn.weinsure1.entities.sinisterstatus;
import tn.weinsure1.entities.typeSinister;
import tn.weinsure1.service.ITableMortaliteService;
import tn.weinsure1.service.IsinisterService;
import tn.weinsure1.service.sinisterServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJpaMvcJspApplicationTest {
	@Autowired 
	IsinisterService is; 
   @Autowired 
   ITableMortaliteService tr; 
   private static final Logger L = LogManager.getLogger(sinisterServiceImpl.class);
 /*
=======
/*
>>>>>>> branch 'master' of https://github.com/yahiabrgb/Weinsure1.git
	@Test
	public void testRetrieveAllUsers() {
		List<sinister> sinistres = is.retrieveAllSinistres() ;
		//Assert.assertEquals(1, sinistres.size()); }
<<<<<<< HEAD
	}
	
	
	@Test
=======
	}*/
   /*s
	@Tests
>>>>>>> branch 'master' of https://github.com/yahiabrgb/Weinsure1.git
	public void testAddSinistre() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2018-02-02");
		sinister s = new sinister (typeSinister.vie, "My first sinistre",d,sinisterstatus.encours , null );
		sinister sinistreAdded = is.addSinistre(s);
		Assert.assertEquals(s.getIdSinistre(), sinistreAdded.getIdSinistre());

	} 
/*

	@Test
	public void testUpdateSinistre() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2018-02-02");
		sinister s = new sinister (2L, typeSinister.vie, "My first sinistre MODIFIED AGAIN",d, sinisterstatus.encours, null );
		sinister sinistreUpdated = is.updateSinistre(s);
		Assert.assertEquals(s.getDescription(), sinistreUpdated.getDescription());

	} 


	@Test
	public void testRetrieveSinistre() {
		sinister sinistre = is.retrieveSinistre("5"); 
		//Assert.assertEquals(5L,sinistre.getIdSinistre().longValue());
	} 

	@Test
	public void testDeleteSinistre() {

		is.deleteSinistre("1");
	}
	@Test
	public void testfindByDescription() {

		List<sinister> sinistres = is.findByDescription("my") ;

	} 

	@Test
	public void testfindByYear() {

		List<sinister> sinistres = is.findByYear("2018") ;

	} 

	@Test
	public void testfindByAny() {

		List<sinister> sinistres = is.findByAny("2018") ;

	} 
	 @Test
	public void testSendMail() {
		is.SendMail();
	}
	/* @Test		//Add tm
		public void TestAddtm() throws ParseException    {
			TableMortalité t0=new TableMortalité(0,100000,100000);	TableMortalité tm0=tr.Addtm(t0);	Assert.assertEquals(t0.getIdTable(),tm0.getIdTable());
			TableMortalité t1=new TableMortalité(1,97104,97660);	TableMortalité tm1=tr.Addtm(t1);	Assert.assertEquals(t1.getIdTable(),tm1.getIdTable());
			TableMortalité t2=new TableMortalité(2,96869,97436);	TableMortalité tm2=tr.Addtm(t2);	Assert.assertEquals(t2.getIdTable(),tm2.getIdTable());
			TableMortalité t3=new TableMortalité(3,96727,97311);	TableMortalité tm3=tr.Addtm(t3);	Assert.assertEquals(t3.getIdTable(),tm3.getIdTable());
			TableMortalité t4=new TableMortalité(4,96624,97223);	TableMortalité tm4=tr.Addtm(t4);	Assert.assertEquals(t4.getIdTable(),tm4.getIdTable());
			TableMortalité t5=new TableMortalité(5,96541,97156);	TableMortalité tm5=tr.Addtm(t5);	Assert.assertEquals(t5.getIdTable(),tm5.getIdTable());
			TableMortalité t6=new TableMortalité(6,96471,97100);	TableMortalité tm6=tr.Addtm(t6);	Assert.assertEquals(t6.getIdTable(),tm6.getIdTable());
			TableMortalité t7=new TableMortalité(7,96410,97051);	TableMortalité tm7=tr.Addtm(t7);	Assert.assertEquals(t7.getIdTable(),tm7.getIdTable());
			TableMortalité t8=new TableMortalité(8,96356,97006);	TableMortalité tm8=tr.Addtm(t8);	Assert.assertEquals(t8.getIdTable(),tm8.getIdTable());
			TableMortalité t9=new TableMortalité(9,96306,96964);	TableMortalité tm9=tr.Addtm(t9);	Assert.assertEquals(t9.getIdTable(),tm9.getIdTable());
			TableMortalité t10=new TableMortalité(10,96258,96923);	TableMortalité tm10=tr.Addtm(t10);	Assert.assertEquals(t10.getIdTable(),tm10.getIdTable());
			TableMortalité t11=new TableMortalité(11,96211,96883);	TableMortalité tm11=tr.Addtm(t11);	Assert.assertEquals(t11.getIdTable(),tm11.getIdTable());
			TableMortalité t12=new TableMortalité(12,96163,96842);	TableMortalité tm12=tr.Addtm(t12);	Assert.assertEquals(t12.getIdTable(),tm12.getIdTable());
			TableMortalité t13=new TableMortalité(13,96111,96800);	TableMortalité tm13=tr.Addtm(t13);	Assert.assertEquals(t13.getIdTable(),tm13.getIdTable());
			TableMortalité t14=new TableMortalité(14,96052,96758);	TableMortalité tm14=tr.Addtm(t14);	Assert.assertEquals(t14.getIdTable(),tm14.getIdTable());
			TableMortalité t15=new TableMortalité(15,95985,96713);	TableMortalité tm15=tr.Addtm(t15);	Assert.assertEquals(t15.getIdTable(),tm15.getIdTable());
			TableMortalité t16=new TableMortalité(16,95908,96667);	TableMortalité tm16=tr.Addtm(t16);	Assert.assertEquals(t16.getIdTable(),tm16.getIdTable());
			TableMortalité t17=new TableMortalité(17,95821,96619);	TableMortalité tm17=tr.Addtm(t17);	Assert.assertEquals(t17.getIdTable(),tm17.getIdTable());
			TableMortalité t18=new TableMortalité(18,95722,96569);	TableMortalité tm18=tr.Addtm(t18);	Assert.assertEquals(t18.getIdTable(),tm18.getIdTable());
			TableMortalité t19=new TableMortalité(19,95614,96517);	TableMortalité tm19=tr.Addtm(t19);	Assert.assertEquals(t19.getIdTable(),tm19.getIdTable());
			TableMortalité t20=new TableMortalité(20,95496,96462);	TableMortalité tm20=tr.Addtm(t20);	Assert.assertEquals(t20.getIdTable(),tm20.getIdTable());
			TableMortalité t21=new TableMortalité(21,95372,96405);	TableMortalité tm21=tr.Addtm(t21);	Assert.assertEquals(t21.getIdTable(),tm21.getIdTable());
			TableMortalité t22=new TableMortalité(22,95242,96346);	TableMortalité tm22=tr.Addtm(t22);	Assert.assertEquals(t22.getIdTable(),tm22.getIdTable());
			TableMortalité t23=new TableMortalité(23,95108,96284);	TableMortalité tm23=tr.Addtm(t23);	Assert.assertEquals(t23.getIdTable(),tm23.getIdTable());
			TableMortalité t24=new TableMortalité(24,94971,96219);	TableMortalité tm24=tr.Addtm(t24);	Assert.assertEquals(t24.getIdTable(),tm24.getIdTable());
			TableMortalité t25=new TableMortalité(25,94834,96151);	TableMortalité tm25=tr.Addtm(t25);	Assert.assertEquals(t25.getIdTable(),tm25.getIdTable());
			TableMortalité t26=new TableMortalité(26,94696,96080);	TableMortalité tm26=tr.Addtm(t26);	Assert.assertEquals(t26.getIdTable(),tm26.getIdTable());
			TableMortalité t27=new TableMortalité(27,94558,96006);	TableMortalité tm27=tr.Addtm(t27);	Assert.assertEquals(t27.getIdTable(),tm27.getIdTable());
			TableMortalité t28=new TableMortalité(28,94420,95929);	TableMortalité tm28=tr.Addtm(t28);	Assert.assertEquals(t28.getIdTable(),tm28.getIdTable());
			TableMortalité t29=new TableMortalité(29,94283,95849);	TableMortalité tm29=tr.Addtm(t29);	Assert.assertEquals(t29.getIdTable(),tm29.getIdTable());
			TableMortalité t30=new TableMortalité(30,94145,95765);	TableMortalité tm30=tr.Addtm(t30);	Assert.assertEquals(t30.getIdTable(),tm30.getIdTable());
			TableMortalité t31=new TableMortalité(31,94007,95677);	TableMortalité tm31=tr.Addtm(t31);	Assert.assertEquals(t31.getIdTable(),tm31.getIdTable());
			TableMortalité t32=new TableMortalité(32,93867,95585);	TableMortalité tm32=tr.Addtm(t32);	Assert.assertEquals(t32.getIdTable(),tm32.getIdTable());
			TableMortalité t33=new TableMortalité(33,93724,95488);	TableMortalité tm33=tr.Addtm(t33);	Assert.assertEquals(t33.getIdTable(),tm33.getIdTable());
			TableMortalité t34=new TableMortalité(34,93578,95387);	TableMortalité tm34=tr.Addtm(t34);	Assert.assertEquals(t34.getIdTable(),tm34.getIdTable());
			TableMortalité t35=new TableMortalité(35,93426,95281);	TableMortalité tm35=tr.Addtm(t35);	Assert.assertEquals(t35.getIdTable(),tm35.getIdTable());
			TableMortalité t36=new TableMortalité(36,93268,95170);	TableMortalité tm36=tr.Addtm(t36);	Assert.assertEquals(t36.getIdTable(),tm36.getIdTable());
			TableMortalité t37=new TableMortalité(37,93102,95052);	TableMortalité tm37=tr.Addtm(t37);	Assert.assertEquals(t37.getIdTable(),tm37.getIdTable());
			TableMortalité t38=new TableMortalité(38,92926,94928);	TableMortalité tm38=tr.Addtm(t38);	Assert.assertEquals(t38.getIdTable(),tm38.getIdTable());
			TableMortalité t39=new TableMortalité(39,92739,94796);	TableMortalité tm39=tr.Addtm(t39);	Assert.assertEquals(t39.getIdTable(),tm39.getIdTable());
			TableMortalité t40=new TableMortalité(40,92538,94656);	TableMortalité tm40=tr.Addtm(t40);	Assert.assertEquals(t40.getIdTable(),tm40.getIdTable());
			TableMortalité t41=new TableMortalité(41,92323,94508);	TableMortalité tm41=tr.Addtm(t41);	Assert.assertEquals(t41.getIdTable(),tm41.getIdTable());
			TableMortalité t42=new TableMortalité(42,92089,94350);	TableMortalité tm42=tr.Addtm(t42);	Assert.assertEquals(t42.getIdTable(),tm42.getIdTable());
			TableMortalité t43=new TableMortalité(43,91837,94180);	TableMortalité tm43=tr.Addtm(t43);	Assert.assertEquals(t43.getIdTable(),tm43.getIdTable());
			TableMortalité t44=new TableMortalité(44,91562,93999);	TableMortalité tm44=tr.Addtm(t44);	Assert.assertEquals(t44.getIdTable(),tm44.getIdTable());
			TableMortalité t45=new TableMortalité(45,91263,93804);	TableMortalité tm45=tr.Addtm(t45);	Assert.assertEquals(t45.getIdTable(),tm45.getIdTable());
			TableMortalité t46=new TableMortalité(46,90937,93594);	TableMortalité tm46=tr.Addtm(t46);	Assert.assertEquals(t46.getIdTable(),tm46.getIdTable());
			TableMortalité t47=new TableMortalité(47,90580,93367);	TableMortalité tm47=tr.Addtm(t47);	Assert.assertEquals(t47.getIdTable(),tm47.getIdTable());
			TableMortalité t48=new TableMortalité(48,90190,93121);	TableMortalité tm48=tr.Addtm(t48);	Assert.assertEquals(t48.getIdTable(),tm48.getIdTable());
			TableMortalité t49=new TableMortalité(49,89764,92854);	TableMortalité tm49=tr.Addtm(t49);	Assert.assertEquals(t49.getIdTable(),tm49.getIdTable());
			TableMortalité t50=new TableMortalité(50,89297,92564);	TableMortalité tm50=tr.Addtm(t50);	Assert.assertEquals(t50.getIdTable(),tm50.getIdTable());
			TableMortalité t51=new TableMortalité(51,88786,92247);	TableMortalité tm51=tr.Addtm(t51);	Assert.assertEquals(t51.getIdTable(),tm51.getIdTable());
			TableMortalité t52=new TableMortalité(52,88226,91901);	TableMortalité tm52=tr.Addtm(t52);	Assert.assertEquals(t52.getIdTable(),tm52.getIdTable());
			TableMortalité t53=new TableMortalité(53,87614,91523);	TableMortalité tm53=tr.Addtm(t53);	Assert.assertEquals(t53.getIdTable(),tm53.getIdTable());
			TableMortalité t54=new TableMortalité(54,86944,91108);	TableMortalité tm54=tr.Addtm(t54);	Assert.assertEquals(t54.getIdTable(),tm54.getIdTable());
			TableMortalité t55=new TableMortalité(55,86211,90651);	TableMortalité tm55=tr.Addtm(t55);	Assert.assertEquals(t55.getIdTable(),tm55.getIdTable());
			TableMortalité t56=new TableMortalité(56,85410,90150);	TableMortalité tm56=tr.Addtm(t56);	Assert.assertEquals(t56.getIdTable(),tm56.getIdTable());
			TableMortalité t57=new TableMortalité(57,84536,89597);	TableMortalité tm57=tr.Addtm(t57);	Assert.assertEquals(t57.getIdTable(),tm57.getIdTable());
			TableMortalité t58=new TableMortalité(58,83582,88988);	TableMortalité tm58=tr.Addtm(t58);	Assert.assertEquals(t58.getIdTable(),tm58.getIdTable());
			TableMortalité t59=new TableMortalité(59,82542,88317);	TableMortalité tm59=tr.Addtm(t59);	Assert.assertEquals(t59.getIdTable(),tm59.getIdTable());
			TableMortalité t60=new TableMortalité(60,81409,87576);	TableMortalité tm60=tr.Addtm(t60);	Assert.assertEquals(t60.getIdTable(),tm60.getIdTable());
			TableMortalité t61=new TableMortalité(61,80178,86757);	TableMortalité tm61=tr.Addtm(t61);	Assert.assertEquals(t61.getIdTable(),tm61.getIdTable());
			TableMortalité t62=new TableMortalité(62,78842,85853);	TableMortalité tm62=tr.Addtm(t62);	Assert.assertEquals(t62.getIdTable(),tm62.getIdTable());
			TableMortalité t63=new TableMortalité(63,77393,84856);	TableMortalité tm63=tr.Addtm(t63);	Assert.assertEquals(t63.getIdTable(),tm63.getIdTable());
			TableMortalité t64=new TableMortalité(64,75826,83754);	TableMortalité tm64=tr.Addtm(t64);	Assert.assertEquals(t64.getIdTable(),tm64.getIdTable());
			TableMortalité t65=new TableMortalité(65,74134,82540);	TableMortalité tm65=tr.Addtm(t65);	Assert.assertEquals(t65.getIdTable(),tm65.getIdTable());
			TableMortalité t66=new TableMortalité(66,72312,81202);	TableMortalité tm66=tr.Addtm(t66);	Assert.assertEquals(t66.getIdTable(),tm66.getIdTable());
			TableMortalité t67=new TableMortalité(67,70354,79729);	TableMortalité tm67=tr.Addtm(t67);	Assert.assertEquals(t67.getIdTable(),tm67.getIdTable());
			TableMortalité t68=new TableMortalité(68,68257,78111);	TableMortalité tm68=tr.Addtm(t68);	Assert.assertEquals(t68.getIdTable(),tm68.getIdTable());
			TableMortalité t69=new TableMortalité(69,66017,76337);	TableMortalité tm69=tr.Addtm(t69);	Assert.assertEquals(t69.getIdTable(),tm69.getIdTable());
			TableMortalité t70=new TableMortalité(70,63632,74395);	TableMortalité tm70=tr.Addtm(t70);	Assert.assertEquals(t70.getIdTable(),tm70.getIdTable());
			TableMortalité t71=new TableMortalité(71,61103,72275);	TableMortalité tm71=tr.Addtm(t71);	Assert.assertEquals(t71.getIdTable(),tm71.getIdTable());
			TableMortalité t72=new TableMortalité(72,58432,69969);	TableMortalité tm72=tr.Addtm(t72);	Assert.assertEquals(t72.getIdTable(),tm72.getIdTable());
			TableMortalité t73=new TableMortalité(73,55623,67469);	TableMortalité tm73=tr.Addtm(t73);	Assert.assertEquals(t73.getIdTable(),tm73.getIdTable());
			TableMortalité t74=new TableMortalité(74,52686,64770);	TableMortalité tm74=tr.Addtm(t74);	Assert.assertEquals(t74.getIdTable(),tm74.getIdTable());
			TableMortalité t75=new TableMortalité(75,49629,61869);	TableMortalité tm75=tr.Addtm(t75);	Assert.assertEquals(t75.getIdTable(),tm75.getIdTable());
			TableMortalité t76=new TableMortalité(76,46469,58769);	TableMortalité tm76=tr.Addtm(t76);	Assert.assertEquals(t76.getIdTable(),tm76.getIdTable());
			TableMortalité t77=new TableMortalité(77,43222,55474);	TableMortalité tm77=tr.Addtm(t77);	Assert.assertEquals(t77.getIdTable(),tm77.getIdTable());
			TableMortalité t78=new TableMortalité(78,39911,51997);	TableMortalité tm78=tr.Addtm(t78);	Assert.assertEquals(t78.getIdTable(),tm78.getIdTable());
			TableMortalité t79=new TableMortalité(79,36560,48356);	TableMortalité tm79=tr.Addtm(t79);	Assert.assertEquals(t79.getIdTable(),tm79.getIdTable());
			TableMortalité t80=new TableMortalité(80,33200,44576);	TableMortalité tm80=tr.Addtm(t80);	Assert.assertEquals(t80.getIdTable(),tm80.getIdTable());
			TableMortalité t81=new TableMortalité(81,29861,40689);	TableMortalité tm81=tr.Addtm(t81);	Assert.assertEquals(t81.getIdTable(),tm81.getIdTable());
			TableMortalité t82=new TableMortalité(82,26580,36735);	TableMortalité tm82=tr.Addtm(t82);	Assert.assertEquals(t82.getIdTable(),tm82.getIdTable());
			TableMortalité t83=new TableMortalité(83,23390,32762);	TableMortalité tm83=tr.Addtm(t83);	Assert.assertEquals(t83.getIdTable(),tm83.getIdTable());
			TableMortalité t84=new TableMortalité(84,20328,28823);	TableMortalité tm84=tr.Addtm(t84);	Assert.assertEquals(t84.getIdTable(),tm84.getIdTable());
			TableMortalité t85=new TableMortalité(85,17428,24976);	TableMortalité tm85=tr.Addtm(t85);	Assert.assertEquals(t85.getIdTable(),tm85.getIdTable());
			TableMortalité t86=new TableMortalité(86,14722,21282);	TableMortalité tm86=tr.Addtm(t86);	Assert.assertEquals(t86.getIdTable(),tm86.getIdTable());
			TableMortalité t87=new TableMortalité(87,12238,17799);	TableMortalité tm87=tr.Addtm(t87);	Assert.assertEquals(t87.getIdTable(),tm87.getIdTable());
			TableMortalité t88=new TableMortalité(88,9997,14583);	TableMortalité tm88=tr.Addtm(t88);	Assert.assertEquals(t88.getIdTable(),tm88.getIdTable());
			TableMortalité t89=new TableMortalité(89,8013,11679);	TableMortalité tm89=tr.Addtm(t89);	Assert.assertEquals(t89.getIdTable(),tm89.getIdTable());
			TableMortalité t90=new TableMortalité(90,6292,9122);	TableMortalité tm90=tr.Addtm(t90);	Assert.assertEquals(t90.getIdTable(),tm90.getIdTable());
			TableMortalité t91=new TableMortalité(91,4832,6931);	TableMortalité tm91=tr.Addtm(t91);	Assert.assertEquals(t91.getIdTable(),tm91.getIdTable());
			TableMortalité t92=new TableMortalité(92,3623,5110);	TableMortalité tm92=tr.Addtm(t92);	Assert.assertEquals(t92.getIdTable(),tm92.getIdTable());
			TableMortalité t93=new TableMortalité(93,2647,3645);	TableMortalité tm93=tr.Addtm(t93);	Assert.assertEquals(t93.getIdTable(),tm93.getIdTable());
			TableMortalité t94=new TableMortalité(94,1876,2498);	TableMortalité tm94=tr.Addtm(t94);	Assert.assertEquals(t94.getIdTable(),tm94.getIdTable());
			TableMortalité t95=new TableMortalité(95,1286,1637);	TableMortalité tm95=tr.Addtm(t95);	Assert.assertEquals(t95.getIdTable(),tm95.getIdTable());
			TableMortalité t96=new TableMortalité(96,850,1019);	TableMortalité tm96=tr.Addtm(t96);	Assert.assertEquals(t96.getIdTable(),tm96.getIdTable());
			TableMortalité t97=new TableMortalité(97,539,597);	TableMortalité tm97=tr.Addtm(t97);	Assert.assertEquals(t97.getIdTable(),tm97.getIdTable());
			TableMortalité t98=new TableMortalité(98,326,326);	TableMortalité tm98=tr.Addtm(t98);	Assert.assertEquals(t98.getIdTable(),tm98.getIdTable());
			TableMortalité t99=new TableMortalité(99,187,164);	TableMortalité tm99=tr.Addtm(t99);	Assert.assertEquals(t99.getIdTable(),tm99.getIdTable());
			TableMortalité t100=new TableMortalité(100,101,75);	TableMortalité tm100=tr.Addtm(t100);	Assert.assertEquals(t100.getIdTable(),tm100.getIdTable());
			TableMortalité t101=new TableMortalité(101,51,30);	TableMortalité tm101=tr.Addtm(t101);	Assert.assertEquals(t101.getIdTable(),tm101.getIdTable());
			TableMortalité t102=new TableMortalité(102,24,10);	TableMortalité tm102=tr.Addtm(t102);	Assert.assertEquals(t102.getIdTable(),tm102.getIdTable());
			TableMortalité t104=new TableMortalité(104,4,1);	TableMortalité tm104=tr.Addtm(t104);	Assert.assertEquals(t104.getIdTable(),tm104.getIdTable());
			TableMortalité t103=new TableMortalité(103,10,3);	TableMortalité tm103=tr.Addtm(t103);	Assert.assertEquals(t103.getIdTable(),tm103.getIdTable());
			TableMortalité t105=new TableMortalité(105,1,0);	TableMortalité tm105=tr.Addtm(t105);	Assert.assertEquals(t105.getIdTable(),tm105.getIdTable());
			TableMortalité t106=new TableMortalité(106,0,0);	TableMortalité tm106=tr.Addtm(t106);	Assert.assertEquals(t106.getIdTable(),tm106.getIdTable());
			TableMortalité t107=new TableMortalité(107,0,0);	TableMortalité tm107=tr.Addtm(t107);	Assert.assertEquals(t107.getIdTable(),tm107.getIdTable());
			TableMortalité t108=new TableMortalité(108,0,0);	TableMortalité tm108=tr.Addtm(t108);	Assert.assertEquals(t108.getIdTable(),tm108.getIdTable());
			TableMortalité t109=new TableMortalité(109,0,0);	TableMortalité tm109=tr.Addtm(t109);	Assert.assertEquals(t109.getIdTable(),tm109.getIdTable());
			TableMortalité t110=new TableMortalité(110,0,0);	TableMortalité tm110=tr.Addtm(t110);	Assert.assertEquals(t110.getIdTable(),tm110.getIdTable());
			TableMortalité t111=new TableMortalité(111,0,0);	TableMortalité tm111=tr.Addtm(t111);	Assert.assertEquals(t111.getIdTable(),tm111.getIdTable());
			TableMortalité t112=new TableMortalité(112,0,0);	TableMortalité tm112=tr.Addtm(t112);	Assert.assertEquals(t112.getIdTable(),tm112.getIdTable());
			TableMortalité t113=new TableMortalité(113,0,0);	TableMortalité tm113=tr.Addtm(t113);	Assert.assertEquals(t113.getIdTable(),tm113.getIdTable());
			TableMortalité t114=new TableMortalité(114,0,0);	TableMortalité tm114=tr.Addtm(t114);	Assert.assertEquals(t114.getIdTable(),tm114.getIdTable());
			TableMortalité t115=new TableMortalité(115,0,0);	TableMortalité tm115=tr.Addtm(t115);	Assert.assertEquals(t115.getIdTable(),tm115.getIdTable());
			TableMortalité t116=new TableMortalité(116,0,0);	TableMortalité tm116=tr.Addtm(t116);	Assert.assertEquals(t116.getIdTable(),tm116.getIdTable());
			TableMortalité t117=new TableMortalité(117,0,0);	TableMortalité tm117=tr.Addtm(t117);	Assert.assertEquals(t117.getIdTable(),tm117.getIdTable());
			TableMortalité t118=new TableMortalité(118,0,0);	TableMortalité tm118=tr.Addtm(t118);	Assert.assertEquals(t118.getIdTable(),tm118.getIdTable());
			TableMortalité t119=new TableMortalité(119,0,0);	TableMortalité tm119=tr.Addtm(t119);	Assert.assertEquals(t119.getIdTable(),tm119.getIdTable());

<<<<<<< HEAD
		}*/
	 /*
	 @Test
		public void testCalcul() {
			float som = tr.calcull(35000, 30, 36, 0.05);	
		}
		*/
   /*
	 @Test
		public void test333() {
		 List<sinister> sinistres = is.findbyuserid(10L);	
		}
		*/
   
	 @Test
		public void test33() {
		 int k = tr.findAgeMax();
		 L.info("description +++ :" + k) ;
		}
	 /*
	 @Test
		public void test334() throws ParseException {
		 SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		 Date d = dateFormat.parse("1970-02-02");
		 User u = new User(10L,d );
		 Contract c = new Contract(10000f ,u) ; 
		 float sm = is.TDEMPRUNTEUR(0.02, u, c) ;

		}
	 /*
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
		}
		*/

	

	
}
    
    