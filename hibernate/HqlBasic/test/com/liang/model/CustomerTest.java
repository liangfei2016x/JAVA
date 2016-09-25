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
		//获取query对象
		Query query=session.createQuery(hql);
		//查询结果为list集合
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer.toString());
		}
	}
	//distinct测试
	@Test
	public void testCustomerDistinct() {
		String hql="select distinct c.sex from Customer c";
		//获取query对象
		Query query=session.createQuery(hql);
		//查询结果为list集合
		List<Object> objects=query.list();
		for (Object object : objects) {
		System.out.println(object);	
		}
	}
	//范围运算 in() 要正好等于里面的值 才可以 
	//between..and..(闭区间)
	@Test
	public void testCustomerIn(){
		String hql="from Customer c where c.age between 20 and 40";
		Query query=session.createQuery(hql);
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer.getName()+","+customer.getAge());
		}
	}
	//like _一个字符   % 0个一个多个任意字符
	@Test
	public void testCustomerLike(){
		//String hql="from Customer c where c.name like '张_'";
		String hql="from Customer c where c.address like '%北京%'";
		Query query=session.createQuery(hql);
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer.getName()+","+customer.getAge()+","+customer.getAddress());
		}
	}
	//uniqueResult 单个对象
	@Test
	public void testCustomeruniqueResult(){
		//String hql="from Customer c where c.name like '张_'";
		String hql="from Customer c where c.name='张三'";
		Query query=session.createQuery(hql);
		Customer customer=(Customer) query.uniqueResult();
		System.out.println(customer.getName());
	}
}
