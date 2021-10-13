package tn.weinsure1.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.weinsure1.entities.Notice;


@Repository
public interface NoticeRepository extends CrudRepository<Notice,Long>  {
	
	@Query(value = "SELECT notice.idnotice, notice.description, notice.state, notice.user_user_id FROM `notice` JOIN user ON notice.user_user_id = user.user_id WHERE user.email = ?1  AND notice.state = 1", nativeQuery = true)
	public List<Notice> NoticeNonLu(String emailUser);

}
