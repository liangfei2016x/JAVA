package com.liang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	/**
	 * 用于存放备选课程的List
	 */
	public List coursesToSelect;
	public ListTest(){
		this.coursesToSelect=new ArrayList();
	}
	public void testadd(){
		Course cr1=new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		//转换为Course类型
		Course temp = (Course) coursesToSelect.get(0);
		System.out.println("添加了课程:"+temp.id+":"+temp.name);
		Course cr2=new Course("2", "C语言");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
		System.out.println("添加了课程:"+temp2.id+":"+temp2.name);
		//temp3 测试数组越界  indexOutofBoundsException
//		Course cr3=new Course("2", "C语言");
//		coursesToSelect.add(3,cr3);
//		Course temp3 = (Course) coursesToSelect.get(0);
//		System.out.println("添加了课程:"+temp3.id+":"+temp3.name);
		Course[] course1={new Course("3", "汇编语言"),new Course("4", "PHP")};
		//把数组转换为list
		coursesToSelect.addAll(Arrays.asList(course1));
		Course temp3 = (Course)coursesToSelect.get(2);
		Course temp4 = (Course)coursesToSelect.get(3);
		System.out.println("又添加了课程："+temp3.id+":"+temp3.name+temp4.id+":"+temp4.name);
		
		Course[] course2={new Course("5", "python"),new Course("6", "高等数学")};
		//把数组转换为list
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course)coursesToSelect.get(2);
		Course temp6 = (Course)coursesToSelect.get(3);
		System.out.println("又添加了课程："+temp5.id+":"+temp5.name+temp6.id+":"+temp6.name);
	}
	//循环输出Arraylist
	public void testGet(){
		int size=coursesToSelect.size();
		for(int i=0;i<size;i++){
			Course cr=(Course) coursesToSelect.get(i);
			System.out.println("我们的课程有:"+cr.id+","+cr.name);
		}
	}
	/**
	 * 迭代器输出List
	 * @param args
	 */
	public void testIterator(){
		//转化为iterator对象
		Iterator it=coursesToSelect.iterator();
		System.out.println("用迭代器输出----------------------------");
		while(it.hasNext()){
			Course cr =(Course)it.next();
			System.out.println("我们的课程有:"+cr.id+","+cr.name);
		}
	}
	/**
	 * foreach 遍历
	 * @param args
	 */
	public void testForeach(){
		System.out.println("通过foreach遍历----------------------");
		for(Object obj:coursesToSelect){
			Course cr=(Course)obj;
			System.out.println("我们的课程有:"+cr.id+","+cr.name);			
		}	
	}
	/**
	 * 修改list
	 */
	public void testModfiy(){
		coursesToSelect.set(4, new Course("7", "JAVA"));
	}
	/**
	 * 删除
	 * @param args
	 */
	public void testRomve(){
	System.out.println("删除测试.");
	//得到对象
	//Course cr=(Course)coursesToSelect.get(0);
	//根据对象删除
	//coursesToSelect.remove(cr);
	
	//根据下标删除
	//coursesToSelect.remove(1);
	
	//删除多个
	Course[] cr={(Course)coursesToSelect.get(0),(Course)coursesToSelect.get(1)};
	coursesToSelect.removeAll(Arrays.asList(cr));
	//输出
	testForeach();
	}
	public void testType(){
		//抛出ClassCastException异常
		coursesToSelect.add("我是一句话");
		
	}
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testadd();//添加 add() addAll()
		lt.testType();
		lt.testForeach();
/*		lt.testGet();//for循环输出
		lt.testIterator();//迭代  Iterator
		lt.testForeach();//遍历 foreach
		lt.testModfiy();//修改 set
		lt.testIterator();
		lt.testRomve();//删除 remove() removeAll()
*/	}
}
