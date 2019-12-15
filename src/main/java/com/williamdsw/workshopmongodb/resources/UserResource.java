package com.williamdsw.workshopmongodb.resources;

import com.williamdsw.workshopmongodb.domain.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll ()
    {
        User maria = new User ("1", "Maria", "maria_silva@gmail.com");
        User alex = new User ("2", "Alex", "alex_green@gmail.com");
        List<User> users = new ArrayList<> ();
        users.addAll (Arrays.asList (maria, alex));
        return ResponseEntity.ok ().body (users);
    }
}