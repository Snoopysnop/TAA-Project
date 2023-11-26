package sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.data.jpa.dao.TeacherDao;
import sample.data.jpa.dao.TeacherDao;
import sample.data.jpa.domain.Teacher;
import sample.data.jpa.dto.TeacherDto;
import sample.data.jpa.mappers.TeacherMapper;
import sample.data.jpa.mappers.TeacherMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeacherMapper teacherMapper;

    public TeacherDto findById(Long id){
        Teacher teacher = teacherDao.findById(id).orElse(null);
        return teacherMapper.mapTeacherDto(teacher);
    }
    public List<TeacherDto> findAll(){

        List<Teacher> teachers = teacherDao.findAll();
        return teachers.stream().map(teacherMapper::mapTeacherDto).collect(Collectors.toList());
    }

    public TeacherDto create (TeacherDto teacherDto){
        Teacher teacher = teacherMapper.mapTeacher(teacherDto);
        teacher = teacherDao.save(teacher);
        return teacherMapper.mapTeacherDto(teacher);
    }

    public TeacherDto update (TeacherDto teacherDto, Long id){
        Teacher teacher = teacherDao.findById(id).orElse(null);
        if(teacher != null){
            teacher = teacherMapper.mapTeacher(teacherDto);
            teacher.setId(id);
            teacher = teacherDao.save(teacher);
            return teacherMapper.mapTeacherDto(teacher);
        }
        return null;
    }

    public void deleteById (Long id){
        Teacher teacher = teacherDao.findById(id).orElse(null);
        if(teacherDao.existsById(id)){
            teacherDao.deleteById(id);
        }
    }
}
