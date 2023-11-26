package fr.istic.taa.jaxrs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.istic.taa.jaxrs.domain.javaClass.Student;
import fr.istic.taa.jaxrs.dto.StudentDto;


@Mapper
public interface StudentMapper {
    //source = ce qu'il y  a en param cad student, target, on veut convertir en ... -> student dto
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "studentNumber", target = "studentNumber")

    StudentDto mapStudentDto(Student student);


    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "studentNumber", target = "studentNumber")

    Student mapStudent(StudentDto studentDto);
}
