package com.semrekkers.traveladvice;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */
public class HelperTest {
    @Test
    public void parseISO8601() throws Exception {
        Date date1 = Helper.parseISO8601("2015-01-19T14:01:00.000Z");
        Date date2 = Helper.parseISO8601("2016-06-20T10:22:01.000Z");
        Date date3 = Helper.parseISO8601("2014-12-12T11:59:02.500Z");

        Calendar cal = Calendar.getInstance();

        cal.setTime(date1);
        assertEquals(cal.get(Calendar.YEAR), 2015);
        assertEquals(cal.get(Calendar.MONTH), Calendar.JANUARY);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 19);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 14);
        assertEquals(cal.get(Calendar.MINUTE), 1);
        assertEquals(cal.get(Calendar.SECOND), 0);

        cal.setTime(date2);
        assertEquals(cal.get(Calendar.YEAR), 2016);
        assertEquals(cal.get(Calendar.MONTH), Calendar.JUNE);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 20);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 10);
        assertEquals(cal.get(Calendar.MINUTE), 22);
        assertEquals(cal.get(Calendar.SECOND), 1);

        cal.setTime(date3);
        assertEquals(cal.get(Calendar.YEAR), 2014);
        assertEquals(cal.get(Calendar.MONTH), Calendar.DECEMBER);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 12);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 11);
        assertEquals(cal.get(Calendar.MINUTE), 59);
        assertEquals(cal.get(Calendar.SECOND), 2);
    }
}