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
	//���
	public static void add(){
		Grade grade=new Grade("JAVAһ��","�������һ��");
		Student student1=new Student("Polo","��");
		Student student2=new Student("Lily","Ů");
		
		//Ϊѧ����Ӱ༶
		student1.setGrade(grade);
		student2.setGrade(grade);
		//��ȡsession
		Session session=HibernateSessionFactory.getSession();
		//��������
		Transaction tx=session.beginTransaction();
		session.save(grade);
		session.save(student1);
		session.save(student2);
		//�ύ����
		tx.commit();
		HibernateSessionFactory.closeSession();
	}	
}
