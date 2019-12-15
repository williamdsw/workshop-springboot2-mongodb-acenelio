package com.williamdsw.workshopmongodb.resources;

import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.services.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William
 */

@RestController
@RequestMapping (value = "/users")
public class UserResource
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    @Autowired
    private UserService service;
    
    //------------------------------------------------------------------------//
    // HELPER FUNCTIONS
    
    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll ()
    {
        List<User> users = service.findAll ();
        return ResponseEntity.ok ().body (users);
    }
}