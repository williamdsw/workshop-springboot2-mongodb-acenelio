package com.williamdsw.workshopmongodb.services.exception;

/**
 * @author William
 */
public class ObjectNotFoundException extends RuntimeException
{
    //------------------------------------------------------------------------//
    // FIELDS
    
    private static final long serialVersionUID = 1L;
    
    //------------------------------------------------------------------------//
    // CONSTRUCTOR
    
    public ObjectNotFoundException (String message)
    {
        super (message);
    }
}