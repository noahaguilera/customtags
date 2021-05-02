package com.noahaguilera.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Returns Message based on the time of day
 */
public class TimeOfDayTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();


        LocalTime morning = LocalTime.of(0, 0, 0);
        LocalTime afterNoon = LocalTime.of(11, 0, 0);
        LocalTime evening = LocalTime.of(15, 0, 0);
        LocalTime night = LocalTime.of(20, 0, 0);

        if (between(morning, afterNoon)) {
            out.println("Good morning!");
        } else if (between(afterNoon, evening)) {
            out.println("Good afternoon!");
        } else if (between(evening, night)) {
            out.println("Good evening!");
        } else {
            out.println("Time for you to get some sleep.");
        }
    }
    private boolean between(LocalTime start, LocalTime end) {
        LocalTime now = java.time.LocalTime.now();
        return (!now.isBefore(start)) && now.isBefore(end);
    }
}
