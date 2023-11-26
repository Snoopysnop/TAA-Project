package sample.data.jpa.domain;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Teacher {

    String name;
    Long id;
    List<Appointment> teacherAppointment;
    protected Teacher() {}

    public Teacher(String name, Long id, List<Appointment> teacherAppointment) {
        this.name = name;
        this.id = id;
        this.teacherAppointment = teacherAppointment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "teacher")
    public List<Appointment> getTeacherAppointment() {
        return teacherAppointment;
    }

    public void setTeacherAppointment(List<Appointment> teacherAppointment) {
        this.teacherAppointment = teacherAppointment;
    }
    @Override
    public String toString() {
        return "Teacher name : " + name;
    }
}
