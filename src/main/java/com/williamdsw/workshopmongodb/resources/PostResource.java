package com.williamdsw.workshopmongodb.resources;

import com.williamdsw.workshopmongodb.domain.Post;
import com.williamdsw.workshopmongodb.resources.utils.URL;
import com.williamdsw.workshopmongodb.services.PostService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping (method = RequestMethod.GET, value = "/title")
    public ResponseEntity<List<Post>> findByTitle (@RequestParam (value = "value", defaultValue = "") String value)
    {
        value = URL.decodeParameters (value);
        List<Post> posts = service.findByTitle (value);
        return ResponseEntity.ok ().body (posts);
    }
    
    @RequestMapping (method = RequestMethod.GET, value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch (
            @RequestParam (value = "text", defaultValue = "") String text, 
            @RequestParam (value = "startDate", defaultValue = "") String startDate, 
            @RequestParam (value = "endDate", defaultValue = "") String endDate)
    {
        text = URL.decodeParameters (text);
        Date start = URL.convertDate (startDate, new Date (0L));
        Date end = URL.convertDate (endDate, new Date ());
        List<Post> posts = service.fullSearch (text, start, end);
        return ResponseEntity.ok ().body (posts);
    }
    
    
}