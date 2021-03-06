package de.swingbe.time_sheet.model;

import de.swingbe.time_sheet.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Project {
    public final static Logger LOG = LoggerFactory.getLogger(Project.class);
    private final String name;
    private Date start;
    private Date end;
    private double hours;

    public Project(String name) {
        this.name = name;

        //todo provide static method for this repeating spaghetti code
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat sdfEndTime = new SimpleDateFormat("dd.MM.yyyyHH:mm");
        //Parsing the given String to Date object
        Date time = null;
        try {
            time = sdfEndTime.parse("01.01.202100:00");
        } catch (ParseException e) {
            LOG.error("ParseException detected, message: "
                    + e.getMessage() + ", trace: "
                    + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
        //todo cleanup LOG.debug("time: " + time);

        this.start = time;
        this.end = time;
        this.hours = 0.0;
    }

    public Project(String name, Date start, Date end, double hours) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", hours=" + hours +
                '}';
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}
