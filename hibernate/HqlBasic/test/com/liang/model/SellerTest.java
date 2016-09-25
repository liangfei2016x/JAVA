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
		//��ȡquery����
		Query query=session.createQuery(hql);
		//��ѯ���Ϊlist����
		List<Seller> sellers=query.list();
		for (Seller seller : sellers) {
			System.out.println(seller.toString());
		}
	}
	//��ѯ�ض����ֶ� ���� ������������
	@Test
	public void testSellerObjectArray() {
		//����ֶ�Ϊ�������
		String hql="select s.name,s.tel,s.address,s.star from Seller s";
		//�����ֶ�Ϊ����
		//String hql="select s.name from Seller s";
		//List<Object> lists =query.list();
		//��ȡquery����
		Query query=session.createQuery(hql);
		//��ѯ���Ϊlist���ϵ�Object[]
		List<Object[]> lists =query.list();
		for (Object[] objects : lists) {
			System.out.println("����:"+objects[0]+" �绰:"+objects[1]+" ��ַ:"+objects[2]+" �Ǽ�:"+objects[3]);
		}
	}
	//����list������ʽ
	@Test
	public void testSelectList(){
		String hql="select new list(s.name,s.tel,s.address) from Seller s";
		Query query=session.createQuery(hql);
		List<List> lists=query.list();
		for (List list : lists) {
			System.out.println(list.get(0)+","+list.get(1)+","+list.get(2));
		}
	}
	//����Map����
	@Test
	public void testSelectMap(){
		//�±���ʽ
		//String hql="select new map(s.name,s.tel,s.address) from Seller s";
		//������ʽ
		String hql="select new map(s.name as name,s.tel as tel,s.address as address) from Seller s";
		Query query=session.createQuery(hql);
		List<Map> lists=query.list();
		for (Map list : lists) {
			//System.out.println(list.get("0")+","+list.get("1")+","+list.get("2"));
			System.out.println(list.get("name")+","+list.get("tel")+","+list.get("address"));
		}
	}
	//�����Զ���Ķ������� Ҫ����Ӧ�Ĺ��캯��
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
