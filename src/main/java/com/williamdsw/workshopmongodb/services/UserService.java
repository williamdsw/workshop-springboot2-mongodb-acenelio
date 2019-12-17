package com.williamdsw.workshopmongodb.services;

import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.domain.dto.UserDTO;
import com.williamdsw.workshopmongodb.repository.UserRepository;
import com.williamdsw.workshopmongodb.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
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
    
    public User findById (String id)
    {
        Optional<User> user = repository.findById (id);
        return user.orElseThrow (() -> new ObjectNotFoundException (String.format ("Usuário não encontrado com id = %s", id)));
    }
    
    public User insert (User user)
    {
        return repository.insert (user);
    }
    
    public User fromDTO (UserDTO dto)
    {
        return new User (dto.getId (), dto.getName (), dto.getEmail ());
    }
}