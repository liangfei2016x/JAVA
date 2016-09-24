package test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionFactory.HibernateSessionFactory;

import entity.Grade;
import entity.Student;

public class Test {

	public static void main(String[] args) {
		add();
		//update();
		//delete();
	}
	//添加
	public static void add(){
		Grade grade=new Grade("JAVA一班","软件开发");
		Student student1=new Student("Polo","男");
		Student student2=new Student("Lily","女");
		
		//添加学生
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);
		
		Session session=HibernateSessionFactory.getSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		session.save(grade);
		session.save(student1);
		session.save(student2);
		//提交事务
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	public static void update(){
		Grade grade=new Grade("JAVA二班","软件开发二");
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		Student student=(Student) session.get(Student.class, 1);
		//修改
		grade.getStudents().add(student);
		session.save(grade);//记得提交
		
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	//删除
	public static void delete(){
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		Student student=(Student)session.get(Student.class, 2);
		session.delete(student);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	
}
