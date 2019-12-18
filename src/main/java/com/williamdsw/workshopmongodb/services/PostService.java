package com.williamdsw.workshopmongodb.services;

import com.williamdsw.workshopmongodb.domain.Post;
import com.williamdsw.workshopmongodb.repository.PostRepository;
import com.williamdsw.workshopmongodb.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author William
 */

@Service
public class PostService
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    @Autowired
    private PostRepository repository;
    
    //------------------------------------------------------------------------//
    // HELPER FUNCTIONS
    
    public Post findById (String id)
    {
        Optional<Post> post = repository.findById (id);
        return post.orElseThrow (() -> new ObjectNotFoundException (String.format ("Post não encontrado com id %s", id)));
    }
    
    public List<Post> findByTitle (String title)
    {
        //return repository.findByTitleContainingIgnoreCase (title);
        return repository.searchTitle (title);
    }
}