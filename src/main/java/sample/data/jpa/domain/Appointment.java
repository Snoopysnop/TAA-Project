package sample.data.jpa.domain;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;



@Entity
public class Appointment{

    Student student;
    Teacher teacher;
    Date date;
    Time startTime;
    Time endTime;
    Long id;

    protected Appointment() {
    }

    public Appointment(Student student, Teacher teacher, Date date) {
        this.student = student;
        this.teacher = teacher;
        this.date = date;
    }
    @ManyToOne(cascade = CascadeType.PERSIST)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    @ManyToOne(cascade = CascadeType.PERSIST)
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue
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
