package jpa.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.DAO.StudentDao;
import jpa.DAO.TeacherDao;
import jpa.javaClass.EntityManagerHelper;
import jpa.javaClass.Student;
import jpa.javaClass.Teacher;

@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {

	EntityManager manager = EntityManagerHelper.getEntityManager();
public void doPost(HttpServletRequest request,
					HttpServletResponse response)
	 throws ServletException, IOException {
	response.setContentType("text/html");

	PrintWriter out = response.getWriter();

	String profFirstName = request.getParameter("professorFirstName");
	String profLastName = request.getParameter("professorLastName");
	String studentFirstName = request.getParameter("studentFirstName");
	String studentLastName = request.getParameter("studentLastName");
	String studentNumber = request.getParameter("studentNumber");
	
	if(studentFirstName != null && studentLastName != null && studentNumber != null){
		
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +			
				" <LI>Student's first name : " + studentFirstName + "\n" +
				" <LI>Student's last name : " + studentLastName + "\n" +
				" <LI>Student's number : " + studentNumber + "\n" +
				"</UL>\n" +	
		"</BODY></HTML>");
		StudentDao studentDao = new StudentDao();
		
		long studentNumberId = Long.parseLong(studentNumber);
		Student newStudent = new Student(studentFirstName, studentLastName, studentNumberId);
		studentDao.create(newStudent);
	}
	else if(profFirstName != null && profLastName!=null){
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +			
				" <LI>Professor's first name : " + profFirstName + "\n" +
				" <LI>Professor's last name : " + profLastName + "\n" +
				"</UL>\n" +
		"</BODY></HTML>");
		TeacherDao teacherDao = new TeacherDao();
		Teacher newTeacher = new Teacher(profFirstName, profLastName);
		teacherDao.create(newTeacher);
	}
	

	
}
}
