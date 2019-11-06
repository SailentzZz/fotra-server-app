package com.fotra.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fotra.database.entities.UserForum;

@Repository
public interface UserForumRepository extends CrudRepository<UserForum, Integer> {
	UserForum findByLoginAndPassword(String login, String password);
	UserForum findByLoginOrEmailOrName(String login, String email, String name);
	UserForum findByLogin(String login);
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