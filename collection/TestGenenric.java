package com.liang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenenric {

	/**�÷������洢����
	 * �����в���ʹ�û������������� Ҫ�����ǵİ�װ��
	 * @param args
	 */
	public List<Course> courses;
	
	public TestGenenric(){
		this.courses=new ArrayList<Course>();
	}
	public void testAdd(){
		Course cr=new Course("1", "JAVA����");
		courses.add(cr);
		Course[]cr2={new Course("2","�ߵ���ѧ"),new Course("3", "ë��")};
		courses.addAll(Arrays.asList(cr2));
 	}
	//��������͵�����
	public void testChildAdd(){
		ChildCourse cc=new ChildCourse();
		cc.id="4";
		cc.name="C++���ŵ���ͨ";
		courses.add(cc);
	}
	public void testForeach(){
		//�������
		for(Course cou:courses){
			System.out.println(cou.id+","+cou.name);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGenenric tg = new TestGenenric();
		tg.testAdd();
		tg.testChildAdd();
		tg.testForeach();
	}

}
