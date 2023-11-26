package fr.istic.taa.jaxrs.dao.myDao;

import java.sql.Time;

import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.javaClass.Student;
import fr.istic.taa.jaxrs.domain.javaClass.TimeSlot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;

public class TimeSlotDao extends Dao<TimeSlot> {
    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();
    
    @Override
    public TimeSlot find(long id) {
        return manager.find(TimeSlot.class, id, LockModeType.NONE, null);
    }

    public TimeSlot findOne(long id) {
        return manager.find(TimeSlot.class,id);
    }

    @Override
    public TimeSlot create(TimeSlot timeSlot) {
        manager.persist(timeSlot);
        return timeSlot;
    }

    @Override
    public TimeSlot update(TimeSlot timeSlot) {
        tx.begin();
        TimeSlot timeSlotToUpdate = manager.merge(timeSlot);
        tx.commit();
        return timeSlotToUpdate;
    }

    @Override
    public void delete(TimeSlot timeSlot) {
        tx.begin();
		manager.remove(timeSlot);
		tx.commit();    
    }

    public void deleteById(long timeSlotId) {
		TimeSlot timeSlotById = findOne(timeSlotId);
		delete(timeSlotById);
	}    
}
