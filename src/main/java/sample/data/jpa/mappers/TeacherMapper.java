package sample.data.jpa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sample.data.jpa.domain.Teacher;
import sample.data.jpa.dto.TeacherDto;

import javax.swing.*;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDto mapTeacherDto(Teacher teacher);

    Teacher mapTeacher(TeacherDto teacherDto);


}