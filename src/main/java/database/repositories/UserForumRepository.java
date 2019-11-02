package database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import database.entities.UserForum;

@Repository
public interface UserForumRepository extends CrudRepository<UserForum, Integer> {

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