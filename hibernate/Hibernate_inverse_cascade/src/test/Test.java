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
	//���
	public static void add(){
		Grade grade=new Grade("JAVAһ��","�������һ��");
		Student student1=new Student("Polo","��");
		Student student2=new Student("Lily","Ů");
		
		//Ϊѧ����Ӱ༶
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);
		student1.setGrade(grade);
		student2.setGrade(grade);
		//��ȡsession
		Session session=HibernateSessionFactory.getSession();
		//��������
		Transaction tx=session.beginTransaction();
		session.save(grade);
//		session.save(student1);
//		session.save(student2);
		//�ύ����
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	//����ɾ��
	public static void delete(){
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		//Student student=(Student)session.get(Student.class, 2);
		Grade grade=(Grade) session.get(Grade.class, 8);
		session.delete(grade);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	//��ѯ
	public static void find(){
		Session session=HibernateSessionFactory.getSession();
		//��ȡѧ����Ϣ
		Student student=(Student) session.get(Student.class, 5);
		System.out.println(student.getSname());
		//��ѧ����ѯѧУ
		Grade grade=student.getGrade();
		System.out.println(grade.getGid());
		HibernateSessionFactory.closeSession();
		
	}
}
