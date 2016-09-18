package com.liang.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/**�����洢ѧ������
	 * @param args
	 */
	public Map<String,Student> students;
	
	public MapTest(){
		this.students=new HashMap<String,Student>();
	}
	//Map��put()����
	public void addStudent(){
		Scanner sc=new Scanner(System.in);
		int i=0;
		while(i<3){
			System.out.print("������ѧ��ID:");
			String id=sc.next();
			//�ж�id�Ƿ����
			Student st=students.get(id);
			if(st==null){
				System.out.println("������ѧ������:");
				String name=sc.next();
				//����ѧ������
				Student student=new Student(id,name);
				 //�Ѷ�����ӵ�Map��
				students.put(id, student);
				i++;
			}else{
				System.out.println("�����Ѿ�����");
				continue;
			}	
		}
	}
	//���ѧ����Ϣ
	public void testKeySet(){
		//����keySet���� ���Map��Key(��ֵ)
		Set<String> keySet= students.keySet();
		for (String stId:keySet ){
			Student student=students.get(stId);
			//����Ϊ��
			if (student != null){
				System.out.println("ѧ����"+student.name);
			}
		}
	}
	//ɾ��
	public void testRomve(){
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("������Ҫɾ����ѧ��ID:");
			String stId=scanner.next();
			Student st=students.get(stId);
			if (st != null) {
				System.out.println("ɾ��ѧ��:"+students.get(stId).name);
				students.remove(stId);
				break;
			}else{
				continue;
			}
		}
	}
	//��һ�ֱ���
	public void testEntrySet(){
		Set<Entry<String, Student>> stdEntry=students.entrySet();
		for(Entry<String, Student> entry:stdEntry){
			System.out.println("��Ϊ:"+entry.getKey());
			System.out.println("ֵΪ:"+entry.getValue().name);
		}
	}
	//�޸�
	public void testModify(){
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("������Ҫ�޸ĵ�ѧ�����:");
			String stId=sc.next();
			Student student=students.get(stId);
			if(student==null){
				System.out.println("�������ѧ��������");
				continue;
			}else{
				System.out.println("������Ҫ�µ�����:");
				String name=sc.next();
				Student std=new Student(stId, name);
				students.put(stId, std);
				System.out.println("�޸����");
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
