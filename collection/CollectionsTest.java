package com.liang.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest {

	/**
	 * @param args
	 * 
	 */
	public void sortTest() {
		Random rm=new Random();
		//����list���洢 rm���ɵ�ֵ
		List<Integer> lt= new ArrayList<Integer>();
		Integer a;
		for(int i=0;i<10;i++){
			do{
				a=rm.nextInt(100);

			}while(lt.contains(a));
			lt.add(a);
		}
		System.out.println("����֮ǰ:"+lt.toString());
		Collections.sort(lt);
		System.out.println("����֮��:"+lt.toString());
		
	}
	
	public static String sortTest2(int length) {
		String base = "abcdefghigklmnopqrstuvwxyz0123456789";
		Random rm=new Random();
		//����list���洢 rm���ɵ�ֵ
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number=rm.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	public void sortTest3(){
		List<Student> st=new ArrayList<Student>();
		st.add(new Student("1", "Tom"));
		st.add(new Student("3", "Jack"));
		st.add(new Student("2", "Maich"));
		System.out.println("��ID����:");
		Collections.sort(st);
		for (Student student : st) {
			System.out.println("ѧ������:"+student.name);
		}
		System.out.println("����������:");
		Collections.sort(st,new StudentComparator());
		for (Student student : st) {
			System.out.println("ѧ������:"+student.name);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest cTest= new CollectionsTest();
		cTest.sortTest();
		List<String> list1=new ArrayList<String>();
		Random random=new Random();
		int length;
		for (int i = 0; i < 10; i++) {
			length = random.nextInt(10)+1;
			list1.add(sortTest2(length));
		}
		System.out.println("����֮ǰ:"+list1.toString());
		Collections.sort(list1);
		System.out.println("����֮��:"+list1.toString());	
		cTest.sortTest3();
	}

}
