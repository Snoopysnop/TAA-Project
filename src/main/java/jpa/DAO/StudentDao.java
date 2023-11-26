package jpa.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import jpa.javaClass.EntityManagerHelper;
import jpa.javaClass.Student;

public class StudentDao extends Dao<Student> {
    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();
    
    public StudentDao(){
        
    }

    //faire attention au fait qu'un num étu doit absolument être unique
    @Override
    public Student find(long studentNumber) {
        return manager.find(Student.class, studentNumber, LockModeType.NONE, null);
    }

    @Override
    public void create(Student student) {
        tx.begin();
        manager.persist(student);
        tx.commit();
    }

    @Override
    public void update(Student student) {
        manager.refresh(student, LockModeType.NONE, null);
    }
    
    @Override
    public void delete(Student student) {
        manager.detach(student);
    }
}
