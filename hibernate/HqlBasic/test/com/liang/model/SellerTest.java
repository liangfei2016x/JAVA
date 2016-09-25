package com.liang.model;



import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;





import com.liang.util.HibernateSessionFactory;

public class SellerTest {
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
	public void testSeller() {
		String hql="from Seller";
		//获取query对象
		Query query=session.createQuery(hql);
		//查询结果为list集合
		List<Seller> sellers=query.list();
		for (Seller seller : sellers) {
			System.out.println(seller.toString());
		}
	}
	//查询特定的字段 返回 对象数据类型
	@Test
	public void testSellerObjectArray() {
		//多个字段为数组对象
		String hql="select s.name,s.tel,s.address,s.star from Seller s";
		//单个字段为对象
		//String hql="select s.name from Seller s";
		//List<Object> lists =query.list();
		//获取query对象
		Query query=session.createQuery(hql);
		//查询结果为list集合的Object[]
		List<Object[]> lists =query.list();
		for (Object[] objects : lists) {
			System.out.println("名字:"+objects[0]+" 电话:"+objects[1]+" 地址:"+objects[2]+" 星级:"+objects[3]);
		}
	}
	//返回list集合形式
	@Test
	public void testSelectList(){
		String hql="select new list(s.name,s.tel,s.address) from Seller s";
		Query query=session.createQuery(hql);
		List<List> lists=query.list();
		for (List list : lists) {
			System.out.println(list.get(0)+","+list.get(1)+","+list.get(2));
		}
	}
	//返回Map类型
	@Test
	public void testSelectMap(){
		//下标形式
		//String hql="select new map(s.name,s.tel,s.address) from Seller s";
		//别名形式
		String hql="select new map(s.name as name,s.tel as tel,s.address as address) from Seller s";
		Query query=session.createQuery(hql);
		List<Map> lists=query.list();
		for (Map list : lists) {
			//System.out.println(list.get("0")+","+list.get("1")+","+list.get("2"));
			System.out.println(list.get("name")+","+list.get("tel")+","+list.get("address"));
		}
	}
	//返回自定义的对象类型 要有相应的构造函数
	@Test
	public void testSelectSelf(){
		String hql="select new Seller(s.name,s.tel,s.address) from Seller s";
		Query query=session.createQuery(hql);
		List<Seller> sellers=query.list();
		for (Seller seller : sellers) {
			System.out.println(seller.getName()+","+seller.getTel()+","+seller.getAddress());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
