package com.liang.model;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;




import com.liang.util.HibernateSessionFactory;

public class CustomerTest {
	private Session session;
	
	

	@Before
	public void setUp() throws Exception {
	session=HibernateSessionFactory.getSession();
	//Transaction transaction=session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
	session.close();
	}

	@Test
	public void testCustomer() {
		String hql="select from Customer c";
		//��ȡquery����
		Query query=session.createQuery(hql);
		//��ѯ���Ϊlist����
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer.toString());
		}
	}
	//distinct����
	@Test
	public void testCustomerDistinct() {
		String hql="select distinct c.sex from Customer c";
		//��ȡquery����
		Query query=session.createQuery(hql);
		//��ѯ���Ϊlist����
		List<Object> objects=query.list();
		for (Object object : objects) {
		System.out.println(object);	
		}
	}
	//��Χ���� in() Ҫ���õ��������ֵ �ſ��� 
	//between..and..(������)
	@Test
	public void testCustomerIn(){
		String hql="from Customer c where c.age between 20 and 40";
		Query query=session.createQuery(hql);
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer.getName()+","+customer.getAge());
		}
	}
	//like _һ���ַ�   % 0��һ����������ַ�
	@Test
	public void testCustomerLike(){
		//String hql="from Customer c where c.name like '��_'";
		String hql="from Customer c where c.address like '%����%'";
		Query query=session.createQuery(hql);
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer.getName()+","+customer.getAge()+","+customer.getAddress());
		}
	}
	//uniqueResult ��������
	@Test
	public void testCustomeruniqueResult(){
		//String hql="from Customer c where c.name like '��_'";
		String hql="from Customer c where c.name='����'";
		Query query=session.createQuery(hql);
		Customer customer=(Customer) query.uniqueResult();
		System.out.println(customer.getName());
	}
}
