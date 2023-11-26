package fr.istic.taa.jaxrs.dto;

import java.io.Serializable;
import java.util.List;

import fr.istic.taa.jaxrs.domain.javaClass.DateTimeSlot;

public class TeacherDto implements Serializable{

    private String firstName;
    private String lastName;
    private long id;
    List<DateTimeSlot> date_availability;
    

    
    public TeacherDto(){

    }
    
    public TeacherDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DateTimeSlot> getDate_availability() {
        return date_availability;
    }

    public void setDate_availability(List<DateTimeSlot> date_availability) {
        this.date_availability = date_availability;
    }

}
