package sample.data.jpa.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Teacher;

@Transactional
public interface TeacherDao extends JpaRepository<Teacher, Long> {

}
