package sample.data.jpa.dto;


import java.util.List;

public class TeacherDto{

    String name;
    Long id;

    public TeacherDto(){

    }
    public TeacherDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
