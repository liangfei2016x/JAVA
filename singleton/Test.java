package com.liang.singleton;
/**
 * ����
 * ����ģʽ���������ʱ��Ƚ���,������ʱ���ض���ȽϿ� ���̰߳�ȫ
 * ����ģʽ���������ʱ��ȽϿ�,������ʱ�ڼ�����Ƚ���  ���̲߳���ȫ
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		
		//����ģʽ
		Singleton s1=Singleton.getSingleton();
		Singleton s2=Singleton.getSingleton();
		System.out.println(s1==s2);
		//����ģʽ �õ�ʱ��ż���
		Singleton2 s3=Singleton2.getSingleton2();
		Singleton2 s4=Singleton2.getSingleton2();
		System.out.println(s3==s4);
	}
}
