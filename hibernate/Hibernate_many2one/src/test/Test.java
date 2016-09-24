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
		Grade grade=new Grade("JAVAһ��","�������");
		Student student1=new Student("Polo","��");
		Student student2=new Student("Lily","Ů");
		
		//���ѧ��
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);
		
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
	public static void update(){
		Grade grade=new Grade("JAVA����","���������");
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		Student student=(Student) session.get(Student.class, 1);
		//�޸�
		grade.getStudents().add(student);
		session.save(grade);//�ǵ��ύ
		
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	//ɾ��
	public static void delete(){
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		Student student=(Student)session.get(Student.class, 2);
		session.delete(student);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	
}
