package com.williamdsw.workshopmongodb.resources;

import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.domain.dto.UserDTO;
import com.williamdsw.workshopmongodb.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
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
    public ResponseEntity<List<UserDTO>> findAll ()
    {
        List<User> users = service.findAll ();
        List<UserDTO> usersDto = users.stream ().map (user -> new UserDTO (user)).collect (Collectors.toList ());
        return ResponseEntity.ok ().body (usersDto);
    }
}