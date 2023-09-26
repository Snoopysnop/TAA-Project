package jpa.DAO;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jpa.javaClass.EntityManagerHelper;
import jpa.javaClass.Teacher;
import jpa.javaClass.TimeSlot;

public class TeacherDao extends Dao<Teacher> {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public boolean addTimeSlot(Date date, List<TimeSlot> timeSlots) {
        return false;
    }

    @Override
    public Teacher find(long id) {
        return manager.find(Teacher.class, id, LockModeType.NONE, null);
    }

    @Override
    public void create(Teacher teacher) {
        manager.persist(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        manager.refresh(teacher, LockModeType.NONE, null);
    }

    @Override
    public void delete(Teacher teacher) {
        manager.detach(teacher);
    }
}
