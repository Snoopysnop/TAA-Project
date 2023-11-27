package fr.istic.taa.jaxrs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import fr.istic.taa.jaxrs.dao.myDao.StudentDao;
import fr.istic.taa.jaxrs.dao.myDao.TeacherDao;
import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.Student;
import fr.istic.taa.jaxrs.domain.javaClass.Teacher;
import fr.istic.taa.jaxrs.dto.AppointmentDto;

    
@Mapper()
public interface AppointmentMapper {

@Mapping(source = "student.studentNumber", target = "studentId")
@Mapping(source = "teacher.id", target = "teacherId")
AppointmentDto mapAppointmentDto(Appointment appointment);

@Mapping(source = "studentId", target = "student", qualifiedByName = "fromIdStudent")
@Mapping(source = "teacherId", target = "teacher", qualifiedByName = "fromIdTeacher")
Appointment mapAppointment(AppointmentDto appointmentDto);

@Named("fromIdStudent")
public default Student fromIdStudent(Long id){
        StudentDao studentDao = new StudentDao();
        return studentDao.find(id);

}
@Named("fromIdTeacher")
public default Teacher fromIdTeacher(Long id){
    TeacherDao teacherDao = new TeacherDao();
    return teacherDao.find(id);
}
}