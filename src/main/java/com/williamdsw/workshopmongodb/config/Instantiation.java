package com.williamdsw.workshopmongodb.config;

import com.williamdsw.workshopmongodb.domain.Post;
import com.williamdsw.workshopmongodb.domain.User;
import com.williamdsw.workshopmongodb.domain.dto.AuthorDTO;
import com.williamdsw.workshopmongodb.domain.dto.CommentDTO;
import com.williamdsw.workshopmongodb.repository.PostRepository;
import com.williamdsw.workshopmongodb.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
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
    
    @Autowired
    private PostRepository postRepository;
    
    //------------------------------------------------------------------------//
    // OVERRIDED FUNCTIONS
    
    @Override
    public void run (String... args) throws Exception
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        dateFormat.setTimeZone (TimeZone.getTimeZone ("GMT"));
        
        // Deleta dados da colecao
        userRepository.deleteAll ();
        postRepository.deleteAll ();
        
        // USER
        User maria = new User (null, "Maria Brown", "maria@gmail.com");
        User alex = new User (null, "Alex Green", "alex@gmail.com");
        User bob = new User (null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll (Arrays.asList (maria, alex, bob));
        
        // POST
        Post post1 = new Post (null, dateFormat.parse ("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo! Abraços", new AuthorDTO (maria));
        Post post2 = new Post (null, dateFormat.parse ("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO (maria));
        
        // COMMENT
        CommentDTO comment1 = new CommentDTO ("Boa viagem mano!", dateFormat.parse ("21/03/2018"), new AuthorDTO (alex));
        CommentDTO comment2 = new CommentDTO ("Aproveite", dateFormat.parse ("22/03/2018"), new AuthorDTO (bob));
        CommentDTO comment3 = new CommentDTO ("Tenha um ótimo dia!", dateFormat.parse ("23/03/2018"), new AuthorDTO (alex));
        post1.getComments ().addAll (Arrays.asList (comment1, comment2));
        post2.getComments ().addAll (Arrays.asList (comment3));
        
        postRepository.saveAll (Arrays.asList (post1, post2));
        maria.getPosts ().addAll (Arrays.asList (post1, post2));
        userRepository.save (maria);
    }
}