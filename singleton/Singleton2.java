package com.liang.singleton;
//����ģʽ
public class Singleton2 {
	private Singleton2(){}
	//�Ȳ�����ʵ����
	private static Singleton2 singleton2;
	//
	public static Singleton2 getSingleton2(){
		//�ж� Ϊ�յ�ʱ���ڽ���ʵ����
		if(singleton2==null){
			singleton2=new Singleton2();
		}
		return singleton2;
	}
}
