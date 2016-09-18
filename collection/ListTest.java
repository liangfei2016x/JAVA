package com.liang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	/**
	 * ���ڴ�ű�ѡ�γ̵�List
	 */
	public List coursesToSelect;
	public ListTest(){
		this.coursesToSelect=new ArrayList();
	}
	public void testadd(){
		Course cr1=new Course("1", "���ݽṹ");
		coursesToSelect.add(cr1);
		//ת��ΪCourse����
		Course temp = (Course) coursesToSelect.get(0);
		System.out.println("����˿γ�:"+temp.id+":"+temp.name);
		Course cr2=new Course("2", "C����");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
		System.out.println("����˿γ�:"+temp2.id+":"+temp2.name);
		//temp3 ��������Խ��  indexOutofBoundsException
//		Course cr3=new Course("2", "C����");
//		coursesToSelect.add(3,cr3);
//		Course temp3 = (Course) coursesToSelect.get(0);
//		System.out.println("����˿γ�:"+temp3.id+":"+temp3.name);
		Course[] course1={new Course("3", "�������"),new Course("4", "PHP")};
		//������ת��Ϊlist
		coursesToSelect.addAll(Arrays.asList(course1));
		Course temp3 = (Course)coursesToSelect.get(2);
		Course temp4 = (Course)coursesToSelect.get(3);
		System.out.println("������˿γ̣�"+temp3.id+":"+temp3.name+temp4.id+":"+temp4.name);
		
		Course[] course2={new Course("5", "python"),new Course("6", "�ߵ���ѧ")};
		//������ת��Ϊlist
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course)coursesToSelect.get(2);
		Course temp6 = (Course)coursesToSelect.get(3);
		System.out.println("������˿γ̣�"+temp5.id+":"+temp5.name+temp6.id+":"+temp6.name);
	}
	//ѭ�����Arraylist
	public void testGet(){
		int size=coursesToSelect.size();
		for(int i=0;i<size;i++){
			Course cr=(Course) coursesToSelect.get(i);
			System.out.println("���ǵĿγ���:"+cr.id+","+cr.name);
		}
	}
	/**
	 * ���������List
	 * @param args
	 */
	public void testIterator(){
		//ת��Ϊiterator����
		Iterator it=coursesToSelect.iterator();
		System.out.println("�õ��������----------------------------");
		while(it.hasNext()){
			Course cr =(Course)it.next();
			System.out.println("���ǵĿγ���:"+cr.id+","+cr.name);
		}
	}
	/**
	 * foreach ����
	 * @param args
	 */
	public void testForeach(){
		System.out.println("ͨ��foreach����----------------------");
		for(Object obj:coursesToSelect){
			Course cr=(Course)obj;
			System.out.println("���ǵĿγ���:"+cr.id+","+cr.name);			
		}	
	}
	/**
	 * �޸�list
	 */
	public void testModfiy(){
		coursesToSelect.set(4, new Course("7", "JAVA"));
	}
	/**
	 * ɾ��
	 * @param args
	 */
	public void testRomve(){
	System.out.println("ɾ������.");
	//�õ�����
	//Course cr=(Course)coursesToSelect.get(0);
	//���ݶ���ɾ��
	//coursesToSelect.remove(cr);
	
	//�����±�ɾ��
	//coursesToSelect.remove(1);
	
	//ɾ�����
	Course[] cr={(Course)coursesToSelect.get(0),(Course)coursesToSelect.get(1)};
	coursesToSelect.removeAll(Arrays.asList(cr));
	//���
	testForeach();
	}
	public void testType(){
		//�׳�ClassCastException�쳣
		coursesToSelect.add("����һ�仰");
		
	}
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testadd();//��� add() addAll()
		lt.testType();
		lt.testForeach();
/*		lt.testGet();//forѭ�����
		lt.testIterator();//����  Iterator
		lt.testForeach();//���� foreach
		lt.testModfiy();//�޸� set
		lt.testIterator();
		lt.testRomve();//ɾ�� remove() removeAll()
*/	}
}
