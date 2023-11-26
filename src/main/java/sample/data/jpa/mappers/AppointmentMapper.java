package sample.data.jpa.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sample.data.jpa.dao.StudentDao;
import sample.data.jpa.dao.TeacherDao;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Student;
import sample.data.jpa.domain.Teacher;
import sample.data.jpa.dto.AppointmentDto;

@Mapper(componentModel = "spring", uses = {TeacherDao.class, StudentDao.class})
public interface AppointmentMapper {

    @Mapping(source = "student.studentNumber", target = "studentId")
    @Mapping(source = "teacher.id", target = "teacherId")
    AppointmentDto mapAppointmentDto(Appointment appointment);

    @Mapping(source = "studentId", target = "student", qualifiedByName = "fromIdStudent")
    @Mapping(source = "teacherId", target = "teacher", qualifiedByName = "fromIdTeacher")
    Appointment mapAppointment(AppointmentDto appointmentDto, @Context TeacherDao teacherDao, @Context StudentDao studentDao);

    @Named("fromIdStudent")
    default Student fromIdStudent(Long id, @Context StudentDao studentDao){
        if(id == null){
            return null;
        }
        return studentDao.findById(id).orElse(null);
    }
    @Named("fromIdTeacher")
    default Teacher fromIdTeacher(Long id, @Context TeacherDao teacherDao){
        if(id == null){
            return null;
        }
        return teacherDao.findById(id).orElse(null);
    }
}
