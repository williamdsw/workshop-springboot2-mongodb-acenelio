package com.williamdsw.workshopmongodb.resources;

import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.domain.dto.UserDTO;
import com.williamdsw.workshopmongodb.services.UserService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    @RequestMapping (method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable String id)
    {
        User user = service.findById (id);
        UserDTO userDto = new UserDTO (user);
        return ResponseEntity.ok ().body (userDto);
    }
    
    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody UserDTO dto)
    {
        User user = service.fromDTO (dto);
        user.setId (null);
        user = service.insert (user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (user.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
}