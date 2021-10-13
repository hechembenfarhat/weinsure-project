package tn.weinsure1.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Contraint;
import tn.weinsure1.entities.Notice;
import tn.weinsure1.entities.User;
import tn.weinsure1.service.INoticeService;

@RestController
public class NoticeController {
	
	@Autowired
	INoticeService ins;
	
	@PostMapping("/addNotice")
	@ResponseBody	
	public Notice addNotice(@RequestBody Notice c) {
		User user = new User();
		//Convertir de Long à int
		Long l2=Long.valueOf(1);
		user.setId(l2);
		c.setUser(user);
	return ins.AddNotice(c);
	}
	
	@GetMapping("/retrieveAllNotices")
	@ResponseBody
	public List<Notice> getNotice() {
	 List<Notice> c = ins.RetrieveAllNotices();
	 return c;
	 }
	
	@DeleteMapping("/deleteNotices/{idcontract}")
	@ResponseBody
	public void removeUser(@PathVariable("idcontract") String idc) {
		ins.DeleteNotice(idc);
	}
	
	@PutMapping("/updateNotice")
	@ResponseBody	
	public Notice updateNotice(@RequestBody Notice c) {
		User user = new User();
		//Convertir de Long à int
		Long l2=Long.valueOf(1);
		user.setId(l2);
		c.setUser(user);
	return ins.UpdateNotice(c);
	}
	
	@GetMapping("/noticeNonLu/{emailUser}")
	@ResponseBody
	public List<Notice> noticeNonLu(@PathVariable("emailUser") String emailUser) {
	 List<Notice> c = ins.NoticeNonLu(emailUser);
	 return c;
	 }
	

}
