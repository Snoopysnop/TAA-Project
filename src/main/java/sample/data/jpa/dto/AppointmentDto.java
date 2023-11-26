package sample.data.jpa.dto;

import java.sql.Time;
import java.util.Date;

public class AppointmentDto{

    Long studentId;
    Long teacherId;
    Date date;
    Time startTime;
    Time endTime;
    Long id;

    public AppointmentDto(){

    }
    public AppointmentDto(Long studentId, Long teacherId, Date date, Time startTime, Time endTime) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
