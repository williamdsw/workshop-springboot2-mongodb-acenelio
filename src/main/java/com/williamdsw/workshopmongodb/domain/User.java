package com.williamdsw.workshopmongodb.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author William
 */


public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String email;

    public User () {}
    public User (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

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