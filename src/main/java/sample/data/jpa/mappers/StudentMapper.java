package sample.data.jpa.mappers;

import org.mapstruct.Mapper;
import sample.data.jpa.domain.Student;
import sample.data.jpa.dto.StudentDto;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto mapStudentDto(Student student);

    Student mapStudent(StudentDto studentDto);
}