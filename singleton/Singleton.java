package com.liang.singleton;
/**
 * ����ģʽ
 * ��֤Ӧ�ó����е�ĳ��ʵ��ֻ��һ��
 * ����ģʽ  ����ģʽ
 * @author Administrator
 *
 */
//����ģʽ
//����� ���ʵ���ʹ�����
public class Singleton {
	//���췽��˽�л� ����������ֱ�Ӵ�������
	private Singleton(){}
	//����һ��Ψһʵ�� ��static���� ��������ming.������ ���� 
	private	static Singleton singleton=new Singleton();
	//����һ����ȡʵ���ķ���
	public static Singleton getSingleton() {
		return singleton;
	}
}
