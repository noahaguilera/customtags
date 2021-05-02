package com.noahaguilera.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Returns Message based on Holiday/Special Days
 */
public class SpecialDayTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM");
        Date today = new Date();
        try {
            Date christmas = dateFormat.parse("25/12");
            if(dateFormat.format(christmas).equals(dateFormat.format(today))) {
                out.println("Merry Christmas!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date halloween = dateFormat.parse("31/10");
            if(dateFormat.format(halloween).equals(dateFormat.format(today))) {
                out.println("Happy Halloween!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date fourthOfJuly = dateFormat.parse("04/07");
            if(dateFormat.format(fourthOfJuly).equals(dateFormat.format(today))) {
                out.println("Happy 4th of July!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date birthday = dateFormat.parse("30/08");
            if(dateFormat.format(birthday).equals(dateFormat.format(today))) {
                out.println("Happy Birthday Noah!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}