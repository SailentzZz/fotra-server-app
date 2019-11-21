package com.fotra.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fotra.database.entities.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>{

}
