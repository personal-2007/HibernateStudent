

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		Configuration con=new  Configuration();
		con.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		
		con.setProperty("hibernate.connection.url","jdbc:mysql://db01.dbhost.dev:5051/db_4559rssjb");
		
		con.setProperty("hibernate.connection.username","user_4559rssjb");
		
		con.setProperty("hibernate.connection.password","p4559rssjb");
		
		con.setProperty("hibernate.hbm2ddl.auto","update");
		con.setProperty("hibernate.show_sql","true");
		con.setProperty("hibernate.format_sql","true");
		
		con.addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory =con.buildSessionFactory();
		Session session =sessionFactory.openSession();
		
		Student student =new Student(123, "selva", "selva2007sk@gmail.com", "Advance Java Program");
		session.beginTransaction();
		
		session.persist(student); 
		session.getTransaction().commit();
		
		System.out.println("Student inserted successfully");
	}

}
