package com.williamdsw.workshopmongodb.services;

import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author William
 */

@Service
public class UserService
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    @Autowired
    private UserRepository repository;
    
    //------------------------------------------------------------------------//
    // HELPER FUNCTIONS
    
    public List<User> findAll ()
    {
        return repository.findAll ();
    }
}