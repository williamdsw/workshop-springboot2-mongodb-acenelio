package com.williamdsw.workshopmongodb.repository;

import com.williamdsw.workshopmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William
 */

@Repository
public interface UserRepository extends MongoRepository<User, String>
{
    
}