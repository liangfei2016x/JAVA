package com.liang.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/**用来存储学生对象
	 * @param args
	 */
	public Map<String,Student> students;
	
	public MapTest(){
		this.students=new HashMap<String,Student>();
	}
	//Map的put()方法
	public void addStudent(){
		Scanner sc=new Scanner(System.in);
		int i=0;
		while(i<3){
			System.out.print("请输入学生ID:");
			String id=sc.next();
			//判断id是否存在
			Student st=students.get(id);
			if(st==null){
				System.out.println("请输入学生姓名:");
				String name=sc.next();
				//创建学生对象
				Student student=new Student(id,name);
				 //把对象添加到Map中
				students.put(id, student);
				i++;
			}else{
				System.out.println("对象已经存在");
				continue;
			}	
		}
	}
	//输出学生信息
	public void testKeySet(){
		//先用keySet方法 获得Map的Key(键值)
		Set<String> keySet= students.keySet();
		for (String stId:keySet ){
			Student student=students.get(stId);
			//对象不为空
			if (student != null){
				System.out.println("学生："+student.name);
			}
		}
	}
	//删除
	public void testRomve(){
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("请输入要删除的学生ID:");
			String stId=scanner.next();
			Student st=students.get(stId);
			if (st != null) {
				System.out.println("删除学生:"+students.get(stId).name);
				students.remove(stId);
				break;
			}else{
				continue;
			}
		}
	}
	//另一种遍历
	public void testEntrySet(){
		Set<Entry<String, Student>> stdEntry=students.entrySet();
		for(Entry<String, Student> entry:stdEntry){
			System.out.println("键为:"+entry.getKey());
			System.out.println("值为:"+entry.getValue().name);
		}
	}
	//修改
	public void testModify(){
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("请输入要修改的学生编号:");
			String stId=sc.next();
			Student student=students.get(stId);
			if(student==null){
				System.out.println("你输入的学生不存在");
				continue;
			}else{
				System.out.println("请输入要新的名字:");
				String name=sc.next();
				Student std=new Student(stId, name);
				students.put(stId, std);
				System.out.println("修改完成");
				break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt=new MapTest();
		mt.addStudent();
		mt.testKeySet();
//		mt.testRomve();
//		mt.testEntrySet();
		mt.testModify();
		mt.testEntrySet();
	}

}
