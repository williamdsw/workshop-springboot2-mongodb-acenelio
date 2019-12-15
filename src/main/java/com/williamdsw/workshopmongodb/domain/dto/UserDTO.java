package com.williamdsw.workshopmongodb.domain.dto;

import com.williamdsw.workshopmongodb.domain.User;
import java.io.Serializable;

/**
 * @author William
 */
public class UserDTO implements Serializable
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;
    
    //------------------------------------------------------------------------//
    // CONSTRUCTORS
    
    public UserDTO () {}
    public UserDTO (User user)
    {
        this.id = user.getId ();
        this.name = user.getName ();
        this.email = user.getEmail ();
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

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }
}
