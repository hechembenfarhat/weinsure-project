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

import tn.weinsure1.entities.User;
import tn.weinsure1.entities.sinister;
import tn.weinsure1.entities.sinisterstatus;
import tn.weinsure1.entities.typeSinister;
import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Role;
import tn.weinsure1.service.IUserService;
/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired 
	IUserService iu;
	
	/*
	
	@Test		//Add user
	
	public void TestAddUser() throws ParseException    {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		
		Date d = dateFormat.parse("1995-02-02");
		User u = new User ("ahmed","joua",d,"hhhh","ggg",123,155788,152, Role.Insurer);
		
		User UserAdded = iu.AddUser(u);
		Assert.assertEquals(u.getIdUser(), UserAdded.getIdUser());
	} 
	 
	@Test		//Update  user 
	public void TestUpdateUser() throws ParseException    {
		Date d =new Date() ;
		
		User u = new User (2L,"Amira_Updated","amira",d,"hhhh","ggg",88,15555,152, Role.Insured);
		User UserUpdated = iu.UpdateUser(u);
		Assert.assertEquals(u.getRole(), UserUpdated.getRole());
	}



	@Test		//Delete User
	public void TestDeleteUser() {
				iu.DeleteUser("4"); 
		}
/*
	@Test		//Show all users
	public void TestRetriveAll() {
		List<User> users= iu.RetrieveAllUsers() ;
		System.out.println(users);
	}
	*//*
	@Test		//Show User 
	public void TestRetriveUser() {
		User user = iu.RetrieveUser("1");
		System.out.println(user);
	}
	
	
	
	/*
	@Test
	public void testfindByYear() {

		List<User> u = iu.findByYearGreater("2021") ;
	} */
	

