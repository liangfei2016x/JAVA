package com.liang.model;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liang.util.HibernateSessionFactory;

public class OrderTest {
	private Session session;

	@Before
	public void setUp() throws Exception {
		session=HibernateSessionFactory.getSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testOrderEmpty() {
		String hql="select new  com.liang.model.Order(o.customer,o.tradeDate,o.status,o.amount)from Order o where o.amount>1000 order by o.amount";
		Query query=session.createQuery(hql);
		List<Order> orders=query.list();
		for (Order order : orders) {
			System.out.println(order.getCustomer().getName());
		}
	}
	@Test
	public void testOrder() {
		String hql="select new  com.liang.model.Order(o.customer,o.tradeDate,o.status,o.amount) from Order o"
				+ " where o.tradeDate between '2015-05-1' and '2015-06-01' and (o.status='已发货' or o.status='已付款')"
				+ " and o.amount>1000 order by status,o.tradeDate desc,o.amount desc";
		Query query=session.createQuery(hql);
		List<Order> orders=query.list();
		for (Order order : orders) {
			System.out.println(order.getCustomer());
		}
	}

}
