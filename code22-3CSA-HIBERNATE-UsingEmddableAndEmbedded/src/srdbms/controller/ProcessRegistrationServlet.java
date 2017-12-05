package srdbms.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import srdbms.model.Address;
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
		student.setLastName(request.getParameter("lastName"));
		student.setFirstName(request.getParameter("firstName"));
		student.setYearLevel(Integer.parseInt(request.getParameter("yearLevel")));
		student.setCourse(request.getParameter("course"));
		student.setDateRegistered(new Date());
		student.setMotto(request.getParameter("motto").trim());
		
		Address address = new Address();
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setZipCode(request.getParameter("zip"));
		
		student.setAddress(address);
		
		SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		Student student2 = (Student) session.get(srdbms.model.Student.class,student.getId());
		
		request.setAttribute("student", student2);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("regstatus.jsp");
		dispatcher.forward(request, response);
	}
}
