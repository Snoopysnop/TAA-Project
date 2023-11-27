package fr.istic.taa.jaxrs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.istic.taa.jaxrs.domain.javaClass.Teacher;
import fr.istic.taa.jaxrs.dto.TeacherDto;

@Mapper
public interface TeacherMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "id", target = "id")

    TeacherDto mapTeacherDto(Teacher teacher);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "id", target = "id")
    
    Teacher mapTeacher(TeacherDto teacherDto);
}