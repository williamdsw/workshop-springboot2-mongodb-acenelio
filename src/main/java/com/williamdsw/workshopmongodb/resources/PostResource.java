package com.williamdsw.workshopmongodb.resources;

import com.williamdsw.workshopmongodb.domain.Post;
import com.williamdsw.workshopmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William
 */

@RestController
@RequestMapping (path = "/posts")
public class PostResource
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    @Autowired
    private PostService service;
    
    //------------------------------------------------------------------------//
    // HELPER FUNCTIONS
    
    @RequestMapping (method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Post> findById (@PathVariable String id)
    {
        Post post = service.findById (id);
        return ResponseEntity.ok ().body (post);
    }
}