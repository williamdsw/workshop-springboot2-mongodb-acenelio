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
    
    // Encontra lista completa
    public List<User> findAll ()
    {
        return repository.findAll ();
    }
    
    // Encontra objeto pelo ID
    public User findById (String id)
    {
        Optional<User> user = repository.findById (id);
        return user.orElseThrow (() -> new ObjectNotFoundException (String.format ("Usuário não encontrado com id = %s", id)));
    }
    
    // Insere
    public User insert (User user)
    {
        return repository.insert (user);
    }
    
    // Exclui
    public void delete (String id)
    {
        findById (id);
        repository.deleteById (id);
    }
    
    // Atualiza
    public User update (User newUser)
    {
        User user = findById (newUser.getId ());
        updateData (newUser, user);
        return repository.save (user);
    }
    
    // Converte com dados do DTO
    public User fromDTO (UserDTO dto)
    {
        return new User (dto.getId (), dto.getName (), dto.getEmail ());
    }
    
    // Atualiza dados de um objeto para outro
    public void updateData (User newUser, User user)
    {
        user.setName (newUser.getName ());
        user.setEmail (newUser.getEmail ());
    }
}