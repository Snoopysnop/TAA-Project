package fr.istic.taa.jaxrs.dao.myDao;

import java.util.Date;

import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.javaClass.Teacher;
import fr.istic.taa.jaxrs.domain.javaClass.TimeSlot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class AppointmentDao extends Dao<Appointment> {
    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    
   @Override
    public Appointment find(long id) {
        TypedQuery<Appointment> query = manager.createQuery("SELECT a FROM Appointment a WHERE a.id = :id", Appointment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public Appointment findOne(long id) {
        return manager.find(Appointment.class,id);
    }
    

    @Override
    public Appointment create(Appointment appointment) {
        // remove availability in teacher
        Teacher teacher = appointment.getTeacher();
        TimeSlot slot = appointment.getTimeSlot();
        Date date = appointment.getDate();
        teacher.removeSlot(date, slot);

        // create appointment

        tx.begin();
        try {
            manager.persist(appointment);
            tx.commit();
        } catch (Exception e) {
            if(tx.isActive() && tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }

        return appointment;
    }
    
    @Override
    public Appointment update(Appointment appointment) {
        //attention a changer le remove
        tx.begin();
        Appointment appointmentToUpdate = manager.merge(appointment);
        tx.commit();
        return appointmentToUpdate;
    }

    @Override
    public void delete(Appointment appointment) {
        tx.begin();
		manager.remove(appointment);
		tx.commit();    
    }

    public void deleteById(long AppointmentId) {
		Appointment appointmentById = findOne(AppointmentId);
		delete(appointmentById);
	}
}