package tn.weinsure1.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.weinsure1.entities.Notice;
import tn.weinsure1.repository.NoticeRepository;
import tn.weinsure1.repository.UserRepository;

@Service

public class NoticeServiceImpl implements INoticeService{
	@Autowired
	NoticeRepository NoticeRepository;
	@Autowired
	UserRepository UserRepository;
	
	private static final Logger L= LogManager.getLogger(NoticeServiceImpl.class);
	@Override
	public List<Notice> RetrieveAllNotices(){
		List<Notice> users = (List<Notice>) NoticeRepository.findAll();
		for (Notice user : users){
			L.info("user +++ :" + user);
		}
		return users;
	}
	@Override
	public Notice AddNotice(Notice c) {
		Notice cnt = NoticeRepository.save(c);
		return cnt;
	}
	@Override
	public void DeleteNotice(String id) {
		NoticeRepository.deleteById(Long.parseLong(id));
	}
	@Override
	public Notice UpdateNotice(Notice c) {
		Notice NoticeUpdated = NoticeRepository.save(c);
		return NoticeUpdated;
	}
	
	@Override
	public Notice RetrieveNotice(String id) {
		L.info("in RetrieveNotice id = " + id);
		Notice c = NoticeRepository.findById(Long.parseLong(id)).get();
		L.info("Notice returned = : " + c);
		return c;	
	}
	@Override
	public List<Notice> NoticeNonLu(String emailUser) {
		List<Notice> notices =  NoticeRepository.NoticeNonLu(emailUser);
		return notices;
	}
}
