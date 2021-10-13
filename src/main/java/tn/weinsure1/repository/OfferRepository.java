package tn.weinsure1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.weinsure1.entities.Contract;
import tn.weinsure1.entities.Offer;
import tn.weinsure1.entities.User;
@Repository
public interface OfferRepository extends CrudRepository<Offer, Long > {

	@Query("select a.user.id from Contract a "
			+ "join Contract b "
			+ "on a.user.id = b.user.id"
			+ " where a.Type like 'Vie' and b.Type like 'Décès'"
			+ "and a.Expiration_date > now() "
			+ "and b.Expiration_date > now()")
	public List<Long> Users_pack1();
	
	@Query("select a.user.id from Contract a "
			+ "join Contract b "
			+ "on a.user.id = b.user.id"
			+ " where a.Type like 'Personne' and b.Type like 'Décès'"
			+ "and a.Expiration_date > now() "
			+ "and b.Expiration_date > now()")
	public List<Long> Users_pack2();
	
	@Query("select a.user.id from Contract a "
			+ "join Contract b "
			+ "on a.user.id = b.user.id"
			+ " where a.Type like 'Vie' and b.Type like 'Dommages'"
			+ "and a.Expiration_date > now() "
			+ "and b.Expiration_date > now()")
	public List<Long> Users_pack3();
	
	@Query("select count(*) from Contract c"
			+ " group by c.user.id"
			+ " order by 1 desc")
	public List<Long> Top_num_Contracts();
	
	@Query("select c.user.id from Contract c"
			+ " group by c.user.id"
			+" HAVING count(*) = ?1 ")
	public List<Long> Top_Users(Long num);
	
	@Query("select distinct c.user.id from Contract c "
			+ "where c.Creation_date = "
			+ "(select min(b.Creation_date) "
			+ "from Contract b)")
	public List<Long> Old_User();
	
	
}
