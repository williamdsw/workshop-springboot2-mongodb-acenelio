package com.williamdsw.workshopmongodb.config;

import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author William
 */

@Configuration
public class Instantiation implements CommandLineRunner
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    @Autowired
    private UserRepository userRepository;
    
    //------------------------------------------------------------------------//
    // OVERRIDED FUNCTIONS
    
    @Override
    public void run (String... args) throws Exception
    {
        // Deleta dados da colecao
        userRepository.deleteAll ();
        
        // Salva dados
        User maria = new User (null, "Maria Brown", "maria@gmail.com");
        User alex = new User (null, "Alex Green", "alex@gmail.com");
        User bob = new User (null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll (Arrays.asList (maria, alex, bob));
    }
}