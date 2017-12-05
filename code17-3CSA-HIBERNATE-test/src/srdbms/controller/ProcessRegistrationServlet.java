package srdbms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import srdbms.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@WebServlet("/processregistration.html")
public class ProcessRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setId(Long.parseLong(request.getParameter("id")));
		student.setLastName(request.getParameter("lastName"));
		student.setFirstName(request.getParameter("firstName"));
		student.setYearLevel(Integer.parseInt(request.getParameter("yearLevel")));
		student.setCourse(request.getParameter("course"));
		
		SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		
		response.sendRedirect("regstatus.jsp");
	}
}
