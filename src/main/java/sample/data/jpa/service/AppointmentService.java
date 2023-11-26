package sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.data.jpa.dao.AppointmentDao;
import sample.data.jpa.dao.AppointmentDao;
import sample.data.jpa.dao.StudentDao;
import sample.data.jpa.dao.TeacherDao;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.dto.AppointmentDto;
import sample.data.jpa.mappers.AppointmentMapper;
import sample.data.jpa.mappers.AppointmentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private AppointmentDao appointmentDao;

    public AppointmentDto findById(Long id){
        Appointment appointment = appointmentDao.findById(id).orElse(null);
        return appointmentMapper.mapAppointmentDto(appointment);
    }
    public List<AppointmentDto> findAll(){

        List<Appointment> appointments = appointmentDao.findAll();
        return appointments.stream().map(appointmentMapper::mapAppointmentDto).collect(Collectors.toList());
    }

    public AppointmentDto create (AppointmentDto appointmentDto){
        Appointment appointment = appointmentMapper.mapAppointment(appointmentDto,teacherDao,studentDao);
        appointment = appointmentDao.save(appointment);
        return appointmentMapper.mapAppointmentDto(appointment);
    }

    public AppointmentDto update (AppointmentDto appointmentDto, Long id){
        Appointment appointment = appointmentDao.findById(id).orElse(null);
        if(appointment != null){
            appointment = appointmentMapper.mapAppointment(appointmentDto,teacherDao,studentDao);
            appointment.setId(id);
            appointment = appointmentDao.save(appointment);
            return appointmentMapper.mapAppointmentDto(appointment);
        }
        return null;
    }

    public void deleteById (Long id){
        Appointment appointment = appointmentDao.findById(id).orElse(null);
        if(appointmentDao.existsById(id)){
            appointmentDao.deleteById(id);
        }
    }
}
