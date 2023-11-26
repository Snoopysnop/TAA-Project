package fr.istic.taa.jaxrs.dto;

import java.io.Serializable;

public class StudentDto implements Serializable{

    String firstName;
    String lastName;
    long studentNumber;

    public StudentDto(){

    }
    
    public StudentDto(String firstName, String lastName, long studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
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
    public long getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }


}
