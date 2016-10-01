package com.liang.singleton;
/**
 * 区别
 * 饿汉模式：加载类的时候比较慢,但运行时加载对象比较快 ：线程安全
 * 懒汉模式：加载类的时候比较快,但运行时在即对象比较慢  ：线程不安全
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		
		//饿汉模式
		Singleton s1=Singleton.getSingleton();
		Singleton s2=Singleton.getSingleton();
		System.out.println(s1==s2);
		//懒汉模式 用的时候才加载
		Singleton2 s3=Singleton2.getSingleton2();
		Singleton2 s4=Singleton2.getSingleton2();
		System.out.println(s3==s4);
	}
}
