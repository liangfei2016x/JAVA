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
	//��ӿγ�
	public void testAdd(){
		Course[] crs={new Course("1","��ѧ"),new Course("2","����"),new Course("3","Ӣ��"),new Course("4","����")};
		coures.addAll(Arrays.asList(crs));
	}
	//��������γ�
	public void testForeach(){
		for (Course cr: coures){
			System.out.println(cr.id+","+cr.name);			
		}
	}
	//contains���� �ж�һ�������Ƿ��ڼ�����
	public void testContains(){
		Course cr=coures.get(0);
		System.out.println("��ȡ�γ�:"+cr.name);
		System.out.println(coures.contains(cr));//true
		//����д����equels���� Ϊfalse ��дΪtrue
		System.out.println("������γ����ƣ�");
		Scanner scanner=new Scanner(System.in);
		String name=scanner.next();
		Course cr2=new Course();
		cr2.name=name;//equals ֻ�ж�ֵһ������
		   
		System.out.println(coures.contains(cr2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st=new SetTest();
		st.testAdd();
		st.testContains();
/*		st.testForeach();		
		Student student=new Student("1","С��");
		System.out.print("��ӭѧ��:"+student.name+"ѡ��");
		Scanner scanner=new Scanner(System.in);
		//��ѡ�񵽵Ŀγ���ӵ�ѧ���Ŀγ̱���
		for(int i=0;i<3;i++){
			System.out.println("������γ�ID:");
			String sid=scanner.next();
			for(Course cr:st.coures){
				if (cr.id.equals(sid)) {
					student.courses.add(cr);
				}
			}			
		}
		//���ѡ��Ŀγ�
		for (Course stcr : student.courses) {
			System.out.println("ѡ���˿γ̣�"+stcr.id+","+stcr.name);			
		}*/
	}

}
