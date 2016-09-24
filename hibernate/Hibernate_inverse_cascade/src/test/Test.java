package test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionFactory.HibernateSessionFactory;

import entity.Grade;
import entity.Student;

public class Test {

	public static void main(String[] args) {
		//add();
		//update();
		//delete();
		find();
	}
	//添加
	public static void add(){
		Grade grade=new Grade("JAVA一班","软件开发一班");
		Student student1=new Student("Polo","男");
		Student student2=new Student("Lily","女");
		
		//为学生添加班级
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);
		student1.setGrade(grade);
		student2.setGrade(grade);
		//获取session
		Session session=HibernateSessionFactory.getSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		session.save(grade);
//		session.save(student1);
//		session.save(student2);
		//提交事务
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	//级联删除
	public static void delete(){
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		//Student student=(Student)session.get(Student.class, 2);
		Grade grade=(Grade) session.get(Grade.class, 8);
		session.delete(grade);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	//查询
	public static void find(){
		Session session=HibernateSessionFactory.getSession();
		//获取学生信息
		Student student=(Student) session.get(Student.class, 5);
		System.out.println(student.getSname());
		//由学生查询学校
		Grade grade=student.getGrade();
		System.out.println(grade.getGid());
		HibernateSessionFactory.closeSession();
		
	}
}
