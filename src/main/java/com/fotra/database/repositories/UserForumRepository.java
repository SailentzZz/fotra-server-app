package com.fotra.database.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fotra.database.entities.UserForum;

@Repository
public interface UserForumRepository extends CrudRepository<UserForum, Integer> {
	UserForum findByLoginAndPassword(String login, String password);
	UserForum findByLoginOrEmailOrName(String login, String email, String name);
	UserForum findByLogin(String login);
	UserForum findByEmail(String Email);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserForum SET password=:password WHERE email=:email")
	void updatePasswordByEmail(@Param("password") String password, @Param("email") String email);
}

//@NoRepositoryBean
//public interface DAORepository<T, ID extends Serializable> extends CrudRepository<T, ID>{
//
//}
//
//@Repository
//interface UserForumDAOImpl extends DAORepository<UserForum, Long>{	
//
//}