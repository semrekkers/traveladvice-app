package com.semrekkers.traveladvice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */

public class Helper {
    public static final DateFormat FORMAT_ISO_8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static Date parseISO8601(String datetime) throws ParseException {
        return FORMAT_ISO_8601.parse(datetime);
    }
}
