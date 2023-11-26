package fr.istic.taa.jaxrs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.dto.AppointmentDto;

    
@Mapper
public interface AppointmentMapper {

    @Mapping(source = "student.studentNumber", target = "studentId")
    @Mapping(source = "teacher.id", target = "teacherId")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "timeSlot", target = "timeSlot")

    AppointmentDto mapAppointmentDto(Appointment appointment);
    

    
    @Mapping(source = "studentId", target = "student.studentNumber")
    @Mapping(source = "teacherId", target = "teacher.id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "timeSlot", target = "timeSlot")

    Appointment mapAppointment(AppointmentDto appointmentDto);

    
}