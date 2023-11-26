package sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.data.jpa.dao.StudentDao;
import sample.data.jpa.domain.Student;
import sample.data.jpa.dto.StudentDto;
import sample.data.jpa.mappers.StudentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentMapper studentMapper;

    public StudentDto findById(Long id){
        Student student = studentDao.findById(id).orElse(null);
        return studentMapper.mapStudentDto(student);
    }
    public List<StudentDto> findAll(){

        List<Student> students = studentDao.findAll();
        return students.stream().map(studentMapper::mapStudentDto).collect(Collectors.toList());
    }

    public StudentDto create (StudentDto studentDto){
        Student student = studentMapper.mapStudent(studentDto);
        student = studentDao.save(student);
        return studentMapper.mapStudentDto(student);
    }

    public StudentDto update (StudentDto studentDto, Long id){
        Student student = studentDao.findById(id).orElse(null);
        if(student != null){
            student = studentMapper.mapStudent(studentDto);
            student.setStudentNumber(id);
            student = studentDao.save(student);
            return studentMapper.mapStudentDto(student);
        }
       return null;
    }

    public void deleteById (Long id){
        Student student = studentDao.findById(id).orElse(null);
        if(studentDao.existsById(id)){
            studentDao.deleteById(id);
        }
    }


}
