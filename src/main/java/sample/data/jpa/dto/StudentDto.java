package sample.data.jpa.dto;


import java.util.List;

public class StudentDto {

    String name;
    Long studentNumber;

    public StudentDto() {

    }

    public StudentDto(String name, Long studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

