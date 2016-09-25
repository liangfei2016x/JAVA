package com.liang.model;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;




import com.liang.util.HibernateSessionFactory;

public class CommodityTest {
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
	public void testCommodity1() {
		String hql="select c.name,c.price,c.seller,c.category from Commodity c where c.category like '%书%' and c.price>10 order by c.price desc,c.name asc";
		Query q=session.createQuery(hql);
		List<Object[]> objects=q.list();
		for (Object[] obj: objects) {
			System.out.println(obj[0]+","+obj[1]);
		}
	}
	//查询
	@Test
	public void testCommodity() {
		String hql="from Commodity";
		Query q=session.createQuery(hql);
		List<Commodity> commodities=q.list();
		for (Commodity commodity : commodities) {
			System.out.println("商品的名字："+commodity.getName());
			//使用lazy加载的时候  查询下面信息才发送sql语句
			//System.out.println("商家的信息："+commodity.getSeller().getName());
		}
	}
	//限制条件 大于
	@Test
	public void testCommodityWhereBig(){
		String hql="from Commodity c where c.price>500";
		Query query=session.createQuery(hql);
		List<Commodity> commodities=query.list();
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+","+commodity.getPrice());
		}
	}
	// null <> =
	@Test
	public void testCommodityWhereNull(){
		String hql="from Commodity c where c.description <> null";
		Query query=session.createQuery(hql);
		List<Commodity> commodities=query.list();
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+","+commodity.getPrice());
		}
	}
	//and or not
	@Test
	public void testCommodityWhereLogic(){
		String hql="from Commodity c where c.price between 4000 and 5000 or c.category like '%电脑%'";
		//createQuery 运行 hql 语句的方法
		Query query=session.createQuery(hql);
		List<Commodity> commodities=query.list();
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+","+commodity.getPrice());
		}
	}
	//+ - * % desc
	@Test
	public void testCommodityWhere(){
		String hql="from Commodity c where c.price*5>=20000 order by price desc";
		Query query=session.createQuery(hql);
		List<Commodity> commodities=query.list();
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+commodity.getPrice());
		}
	}
}
