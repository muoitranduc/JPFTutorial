package com.example;

import org.junit.Test;

import java.util.TimeZone;
import com.example.models.Time;

import static org.junit.Assert.assertEquals;


public class TimeTest {
    
    @Test
    public void testDefaultTimezone() throws Exception {
        final Time time = new Time();
        assertEquals(TimeZone.getDefault().getDisplayName(), time.getTimezone());
    }

    @Test
    public void testSpecifiedTimezone() throws Exception {
        final TimeZone est = TimeZone.getTimeZone("EST");
        final Time time = new Time(est);
        assertEquals(est.getDisplayName(), time.getTimezone());
    }
}
