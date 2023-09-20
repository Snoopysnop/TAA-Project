package jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TimeSlot {
    long id;
    
    int startHour;
    int startMinute;

    int endHour;
    int endMinute;

    Date date;


    public TimeSlot(int startHour, int startMinute, int endHour, int endMinute) {
        if(!checkValidityTimeSlot(startHour,startMinute,endHour,endMinute)){
            throw new IllegalArgumentException("Parameters are not valid.");
        }
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    protected boolean timeSlotOverlap(TimeSlot timeSlot1) {
        int ts1HS = timeSlot1.getStartHour();
        int ts1HE = timeSlot1.getEndHour();
        int ts1MS = timeSlot1.getStartMinute();
        int ts1ME = timeSlot1.getEndMinute();

        int ts2HS = this.startHour;
        int ts2HE = this.endHour;
        int ts2MS = this.startMinute;
        int ts2ME = this.endMinute;


        if (ts1HE < ts2HS || (ts1HE == ts2HS && ts1ME < ts2MS)) {
            return false;
        }

        if (ts1HS > ts2HE || (ts1HS == ts2HE && ts1MS > ts2ME)) {
            return false; 
        }

        return true;
    }

    private boolean checkValidityTimeSlot(int startHour, int startMinute, int endHour, int endMinute){
        return (
            startHour >= 0 && startHour < 24 && endHour >= 0 && endHour < 24 &&
            startMinute >= 0 && startMinute < 60 && endMinute >= 0 && endMinute < 60 &&
            (
                (startHour == endHour && startMinute < endMinute) || (startHour < endHour)
            )
        );
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof TimeSlot && object != null) {
            TimeSlot timeSlot = (TimeSlot)object;
            return (this.startHour == timeSlot.getStartHour()
            && this.startMinute == timeSlot.getStartMinute()
            && this.endHour == timeSlot.getEndHour()
            && this.endMinute == timeSlot.getEndMinute());
        }
        return false;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }
}
