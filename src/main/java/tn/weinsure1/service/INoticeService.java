package tn.weinsure1.service;

import java.util.List;

import tn.weinsure1.entities.Notice;

public interface INoticeService {
  
	List<Notice> RetrieveAllNotices(); 
	Notice AddNotice(Notice c);
	void DeleteNotice(String id);
	Notice UpdateNotice(Notice c);
	Notice RetrieveNotice(String id);
	List<Notice> NoticeNonLu(String emailUser);
	
}
