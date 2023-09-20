package jpa;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
    @ManyToOne(cascade = CascadeType.PERSIST)
    Student student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Teacher teacher;

    Date date;
    @ManyToOne
    TimeSlot timeSlot;


    @Id
    @GeneratedValue
    Long id;

    protected Appointment() {
    }

    public Appointment(Student student, Teacher teacher, Date date) {
        this.student = student;
        this.teacher = teacher;
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

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