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
		Grade grade=new Grade("JAVA一班","软件开发一班");
		Student student1=new Student("Polo","男");
		Student student2=new Student("Lily","女");
		
		//为学生添加班级
		student1.setGrade(grade);
		student2.setGrade(grade);
		//获取session
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
}
