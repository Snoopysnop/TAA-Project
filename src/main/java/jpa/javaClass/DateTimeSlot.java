package jpa.javaClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class DateTimeSlot {
    
    long id;

    Date date;
    List<TimeSlot> timeSlots;

    protected DateTimeSlot() {}
    
    protected DateTimeSlot(Date date, List<TimeSlot> timeSlots) {
        this.date = date;
        this.timeSlots = timeSlots;
    }

    protected DateTimeSlot(Date date, TimeSlot timeSlot) {
        this.date = date;
        this.timeSlots = new ArrayList<>();
        this.timeSlots.add(timeSlot);
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany
    @JoinColumn(name="dateTimeId")
    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
