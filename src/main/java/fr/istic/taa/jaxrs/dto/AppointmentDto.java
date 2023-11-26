package fr.istic.taa.jaxrs.dto;

import java.io.Serializable;
import java.sql.Date;

import fr.istic.taa.jaxrs.domain.javaClass.TimeSlot;


public class AppointmentDto implements Serializable{

    long studentId;
    long teacherId;
    TimeSlot timeSlot;
    

    Date date;
    Long id;
    
    public AppointmentDto(){
        
    }
    public AppointmentDto(long studentId, long teacherId, Date date) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.date = date;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
