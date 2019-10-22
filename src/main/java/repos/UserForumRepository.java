package repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserForumRepository extends CrudRepository<UserForum, Long>{

}
