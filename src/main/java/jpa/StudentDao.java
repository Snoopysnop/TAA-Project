package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class StudentDao extends Dao<Student> {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    @Override
    public Student find(long studentNumber) {
        return manager.find(Student.class, studentNumber, LockModeType.NONE, null);
    }

    @Override
    public void create(Student student) {
        manager.persist(student);
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
