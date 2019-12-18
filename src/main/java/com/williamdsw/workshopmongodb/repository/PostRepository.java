package com.williamdsw.workshopmongodb.repository;

import com.williamdsw.workshopmongodb.domain.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author William
 */

@Repository
public interface PostRepository extends MongoRepository<Post, String>
{
    // Query Method
    public List<Post> findByTitleContainingIgnoreCase (String title);
    
    // Query JSON
    // 'title' = Campo a se buscar
    // ?0 = Indica o primeiro parametro da funcao
    // 'i' = Indica case insensitive
    @Query ("{ 'title': { $regex: ?0, $options: 'i' } }")
    public List<Post> searchTitle (String title);
}