package fr.istic.taa.jaxrs.dao.myDao;

import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.javaClass.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class StudentDao extends Dao<Student> {
    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();
    
    public StudentDao(){
        
    }

    //faire attention au fait qu'un num étu doit absolument être unique
    
    @Override
    public Student find(long id) {
        TypedQuery<Student> query = manager.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Student findOne(long id) {
        return manager.find(Student.class,id);
    }

    @Override
    public Student create(Student student) {
        tx.begin();
        try {
            manager.persist(student);
            tx.commit();
        } catch (Exception e) {
            if(tx.isActive() && tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        

        return student;
    }

    @Override
    public Student update(Student student) {
        tx.begin();
        Student studentToUpdate = manager.merge(student);
        tx.commit();
        return studentToUpdate;
    }

    @Override
    public void delete(Student student) {
        tx.begin();
		manager.remove(student);
		tx.commit();    
    }

    public void deleteById(long studentId) {
		Student studentById = findOne(studentId);
		delete(studentById);
	}
}
