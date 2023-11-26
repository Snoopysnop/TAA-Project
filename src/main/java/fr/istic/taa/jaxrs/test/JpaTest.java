package fr.istic.taa.jaxrs.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.javaClass.Student;
import fr.istic.taa.jaxrs.domain.javaClass.Teacher;
import fr.istic.taa.jaxrs.domain.javaClass.TimeSlot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Student student1 = new Student("Lise", "Ribeiro Gomes", 19022937);
			Student student2 = new Student("Gwenaël", "Gombert", 19005610);
			manager.persist(student1);
			manager.persist(student2);
			
			Date date1 = new Date(1694163600000L);
			Date date1_1 = new Date(1689465600000L);
			Date date2 = new Date(1694167200000L);
			
			ArrayList<TimeSlot> l1 = new ArrayList<>();
			ArrayList<TimeSlot> l1_1 = new ArrayList<>();
			ArrayList<TimeSlot> l2 = new ArrayList<>();
			TimeSlot ts1_1 = new TimeSlot(12, 0, 13, 0);
			TimeSlot ts1_2 = new TimeSlot(15, 8, 16, 30);
			TimeSlot ts1_3 = new TimeSlot(17, 15, 19, 15);
			TimeSlot ts2 = new TimeSlot(13, 0, 15, 0);

			TimeSlot timeSlot1 = new TimeSlot(9, 0, 11, 0);
			TimeSlot timeSlot2 = new TimeSlot(10, 0, 12, 0);
			TimeSlot timeSlot3 = new TimeSlot(8, 0, 9, 0);
			TimeSlot timeSlot4 = new TimeSlot(13, 0, 14, 0);
			TimeSlot timeSlot5 = new TimeSlot(9, 30, 10, 30);


			l1.add(ts1_1);
			l1.add(ts1_2);
			l1.add(ts1_3);

			l1_1.add(ts2);

			l2.add(ts2);

			String date_string = "26-09-1989";
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
			Date date = formatter.parse(date_string);      
			System.out.println("Date value: " + date);

		
			
			

			Teacher teacher1 = new Teacher("Olivier", "Ridoux");
			Teacher teacher2 = new Teacher("Olivier", "Barais");
			manager.persist(teacher1);
			manager.persist(teacher2);
			

			teacher1.addListTimeSlot(date1,l1);
			teacher1.addListTimeSlot(date1_1,l1_1);
			teacher2.addListTimeSlot(date2,l2);


			System.out.println("*********************");
			teacher1.displayDisponibility();
			System.out.println("*********************");

			Date dateDel = new Date(1694163600000L);
			TimeSlot tsDel = new TimeSlot(12, 0, 13, 0);
			teacher1.removeSlot(dateDel,tsDel);

			System.out.println("*********************");
			teacher1.displayDisponibility();
			System.out.println("*********************");


			Appointment appointment1 = new Appointment(student1, teacher1, date1);
			Appointment appointment2 = new Appointment(student2, teacher2, date2);
			manager.persist(appointment1);
			manager.persist(appointment2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}
}
