package sample.data.jpa.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Student;

@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {

}
