package com.williamdsw.workshopmongodb.domain.dto;

import com.williamdsw.workshopmongodb.domain.User;
import java.io.Serializable;

/**
 * @author William
 */
public class AuthorDTO implements Serializable
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    //------------------------------------------------------------------------//
    // CONSTRUCTORS
    
    public AuthorDTO () {}
    public AuthorDTO (User user)
    {
        this.id = user.getId ();
        this.name = user.getName ();
    }

    //------------------------------------------------------------------------//
    // GETTERS / SETTERS
    
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
}