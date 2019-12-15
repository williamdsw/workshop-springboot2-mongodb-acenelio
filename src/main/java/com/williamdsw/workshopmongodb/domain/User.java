package com.williamdsw.workshopmongodb.domain;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author William
 */

// @Document = Indica que a classe corresponse a uma colecao do MongoDB
@Document (collection = "user")
public class User implements Serializable
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String name;
    private String email;

    //------------------------------------------------------------------------//
    // CONSTRUCTORS
    
    public User () {}
    public User (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
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

    //------------------------------------------------------------------------//
    // OVERRIDED FUNCTIONS
    
    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode (this.id);
        return hash;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass () != obj.getClass ())
        {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals (this.id, other.id))
        {
            return false;
        }
        return true;
    }
}