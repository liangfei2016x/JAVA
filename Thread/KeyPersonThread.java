package com.liang.Thread;

public class KeyPersonThread extends Thread {
	//复写run方法
	public void run(){
		System.out.println(Thread.currentThread().getName()+"开始战斗了!");
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"主力军厮杀"+"["+i+"]");
		}
		System.out.println(Thread.currentThread().getName()+"战斗结束!");	
	}
}
