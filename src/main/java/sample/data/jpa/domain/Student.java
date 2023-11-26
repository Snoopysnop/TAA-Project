package sample.data.jpa.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {


    String name;

    Long studentNumber;
    List<Appointment> studentAppointment;
    protected Student() {}

    public Student(String name, List<Appointment> studentAppointment, Long studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.studentAppointment = studentAppointment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue
    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "student")
    public List<Appointment> getStudentAppointment() {
        return studentAppointment;
    }

    public void setStudentAppointment(List<Appointment> studentAppointment) {
        this.studentAppointment = studentAppointment;
    }

    @Override
    public String toString() {
        return "Student name : " + name;
    }
}
