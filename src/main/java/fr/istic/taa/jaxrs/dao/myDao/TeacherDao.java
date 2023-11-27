package fr.istic.taa.jaxrs.dao.myDao;

import java.sql.Date;
import java.util.List;

import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.javaClass.Student;
import fr.istic.taa.jaxrs.domain.javaClass.Teacher;
import fr.istic.taa.jaxrs.domain.javaClass.TimeSlot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class TeacherDao extends Dao<Teacher> {
    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public TeacherDao(){
        
    }

    public boolean addTimeSlot(Date date, List<TimeSlot> timeSlots) {
        return false;
    }

    @Override
    public Teacher find(long id) {
        TypedQuery<Teacher> query = manager.createQuery("SELECT t FROM Teacher t WHERE t.id = :id", Teacher.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Teacher findOne(long id) {
        return manager.find(Teacher.class,id);
    }

    @Override
    public Teacher create(Teacher teacher) {
        tx.begin();
        try {
            manager.persist(teacher);
            tx.commit();
        } catch (Exception e) {
            if(tx.isActive() && tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return teacher;
    }

     @Override
    public Teacher update(Teacher teacher) {
        tx.begin();
        Teacher teacherToUpdate = manager.merge(teacher);
        tx.commit();
        return teacherToUpdate;
    }

    @Override
    public void delete(Teacher teacher) {
        tx.begin();
		manager.remove(teacher);
		tx.commit();    
    }

    public void deleteById(long teacherId) {
		Teacher teacherById = findOne(teacherId);
		delete(teacherById);
	}
}
