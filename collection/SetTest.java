package com.liang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class SetTest {

	/**
	 * @param args
	 */
	public List<Course> coures;
	

	
	public SetTest(){
		this.coures = new ArrayList<Course>();

	}
	//添加课程
	public void testAdd(){
		Course[] crs={new Course("1","数学"),new Course("2","语文"),new Course("3","英语"),new Course("4","物理")};
		coures.addAll(Arrays.asList(crs));
	}
	//迭代输出课程
	public void testForeach(){
		for (Course cr: coures){
			System.out.println(cr.id+","+cr.name);			
		}
	}
	//contains方法 判断一个对象是否在集合中
	public void testContains(){
		Course cr=coures.get(0);
		System.out.println("获取课程:"+cr.name);
		System.out.println(coures.contains(cr));//true
		//不重写对象equels方法 为false 重写为true
		System.out.println("请输入课程名称：");
		Scanner scanner=new Scanner(System.in);
		String name=scanner.next();
		Course cr2=new Course();
		cr2.name=name;//equals 只判断值一个属性
		   
		System.out.println(coures.contains(cr2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st=new SetTest();
		st.testAdd();
		st.testContains();
/*		st.testForeach();		
		Student student=new Student("1","小明");
		System.out.print("欢迎学生:"+student.name+"选课");
		Scanner scanner=new Scanner(System.in);
		//把选择到的课程添加到学生的课程表中
		for(int i=0;i<3;i++){
			System.out.println("请输入课程ID:");
			String sid=scanner.next();
			for(Course cr:st.coures){
				if (cr.id.equals(sid)) {
					student.courses.add(cr);
				}
			}			
		}
		//输出选择的课程
		for (Course stcr : student.courses) {
			System.out.println("选择了课程："+stcr.id+","+stcr.name);			
		}*/
	}

}
