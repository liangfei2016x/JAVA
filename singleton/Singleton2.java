package com.liang.singleton;
//懒汉模式
public class Singleton2 {
	private Singleton2(){}
	//先不进行实例化
	private static Singleton2 singleton2;
	//
	public static Singleton2 getSingleton2(){
		//判断 为空的时候在进行实例化
		if(singleton2==null){
			singleton2=new Singleton2();
		}
		return singleton2;
	}
}
