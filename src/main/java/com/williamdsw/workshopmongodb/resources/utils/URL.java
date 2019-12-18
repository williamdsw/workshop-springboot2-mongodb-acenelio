package com.williamdsw.workshopmongodb.resources.utils;

import java.net.URLDecoder;

/**
 * @author William
 */
public class URL
{
    public static String decodeParameters (String text)
    {
        try
        {
            return URLDecoder.decode (text, "UTF-8");
        }
        catch (Exception e)
        {
            return "";
        }
    }
}