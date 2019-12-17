package com.williamdsw.workshopmongodb.repository;

import com.williamdsw.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William
 */

@Repository
public interface PostRepository extends MongoRepository<Post, String>
{
    
}