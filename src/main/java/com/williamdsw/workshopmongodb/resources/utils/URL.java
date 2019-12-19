package com.williamdsw.workshopmongodb.resources.utils;

import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
    
    public static Date convertDate (String textDate, Date defaultDate)
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
            format.setTimeZone (TimeZone.getTimeZone ("GMT"));
            return format.parse (textDate);
        }
        catch (ParseException ex)
        {
            return defaultDate;
        }
    }
}