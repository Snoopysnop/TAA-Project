package sample.data.jpa.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Appointment;

@Transactional
public interface AppointmentDao extends JpaRepository<Appointment, Long> {

}
