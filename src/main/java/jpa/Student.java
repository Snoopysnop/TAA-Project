package jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student extends User {

    @Id
    Long studentNumber;

    protected Student() {}

    public Student(String firstName, String lastName, long studentNumber) {
        super(firstName, lastName);
        this.studentNumber = studentNumber;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentNumber=" + studentNumber + "]";
    }
}