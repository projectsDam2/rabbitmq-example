package org.iesfm.rabbitmqexample.repository;

import org.iesfm.rabbitmqexample.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
