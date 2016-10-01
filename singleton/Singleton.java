package com.liang.singleton;
/**
 * 单例模式
 * 保证应用程序中的某个实例只有一个
 * 饿汉模式  饱汉模式
 * @author Administrator
 *
 */
//饿汉模式
//类加载 这个实例就创建了
public class Singleton {
	//构造方法私有化 不允许外面直接创建对象
	private Singleton(){}
	//创建一个唯一实例 用static修饰 可以用类ming.属性名 访问 
	private	static Singleton singleton=new Singleton();
	//创建一个获取实例的方法
	public static Singleton getSingleton() {
		return singleton;
	}
}
