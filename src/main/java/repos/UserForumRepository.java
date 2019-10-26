package repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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