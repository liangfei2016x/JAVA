package com.liang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenenric {

	/**用泛型来存储数据
	 * 泛型中不能使用基本的数据类型 要用他们的包装类
	 * @param args
	 */
	public List<Course> courses;
	
	public TestGenenric(){
		this.courses=new ArrayList<Course>();
	}
	public void testAdd(){
		Course cr=new Course("1", "JAVA基础");
		courses.add(cr);
		Course[]cr2={new Course("2","高等数学"),new Course("3", "毛概")};
		courses.addAll(Arrays.asList(cr2));
 	}
	//添加子类型的数据
	public void testChildAdd(){
		ChildCourse cc=new ChildCourse();
		cc.id="4";
		cc.name="C++入门到精通";
		courses.add(cc);
	}
	public void testForeach(){
		//遍历输出
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
