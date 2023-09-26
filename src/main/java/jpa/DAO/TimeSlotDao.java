package jpa.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jpa.javaClass.EntityManagerHelper;
import jpa.javaClass.TimeSlot;

public class TimeSlotDao extends Dao<TimeSlot> {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    @Override
    public TimeSlot find(long id) {
        return manager.find(TimeSlot.class, id, LockModeType.NONE, null);
    }

    @Override
    public void create(TimeSlot timeSlot) {
        manager.persist(timeSlot);
    }

    @Override
    public void update(TimeSlot timeSlot) {
        manager.refresh(timeSlot, LockModeType.NONE, null);
    }

    @Override
    public void delete(TimeSlot timeSlot) {
        manager.detach(timeSlot);
    }    
}
