package jpa;

import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class AppointmentDao extends Dao<Appointment> {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    @Override
    public Appointment find(long id) {
        return manager.find(Appointment.class, id, LockModeType.NONE, null);
    }

    @Override
    public void create(Appointment appointment) {
        // remove availability in teacher
        Teacher teacher = appointment.getTeacher();
        TimeSlot slot = appointment.getTimeSlot();
        Date date = appointment.getDate();
        teacher.removeSlot(date, slot);

        // create appointment
        manager.persist(appointment);
    }

    @Override
    public void update(Appointment appointment) {
         manager.refresh(appointment, LockModeType.NONE, null);
    }

    @Override
    public void delete(Appointment appointment) {
        manager.detach(appointment);
    }
}