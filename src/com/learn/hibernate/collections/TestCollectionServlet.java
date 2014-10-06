package com.learn.hibernate.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class TestCollectionServlet
 */
@WebServlet("/TestCollectionServlet")
public class TestCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCollectionServlet() {
        super();
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 sessionFactory= new Configuration().configure().buildSessionFactory(
				    new StandardServiceRegistryBuilder().build() );
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			Transaction t = session.beginTransaction();
			Showroom sr1= new Showroom();
			sr1.setLocation("Kandivali");
			sr1.setManager("Vinod");
			Car c1 = new Car();
			c1.setColor("white");
			c1.setName("Swift");
			
			Car c2 = new Car();
			c2.setColor("Blue");
			c2.setName("i20 elite");
			
			List<Car> cars = new ArrayList<Car>();
			cars.add(c1);
			cars.add(c2);
			
			sr1.setCars(cars);
			session.save(sr1);
			t.commit();
			
			findShowroom(1);
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private void findShowroom(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Showroom s1=(Showroom)session.load(Showroom.class,id);
		System.out.println("Showroom id : "+s1.getId()+ "showroom location :"+s1.getLocation());
		System.out.println("Cars :"+ s1.getCars().toString());
		t.commit();
	}

}
