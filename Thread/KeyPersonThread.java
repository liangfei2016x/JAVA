package com.liang.Thread;

public class KeyPersonThread extends Thread {
	//��дrun����
	public void run(){
		System.out.println(Thread.currentThread().getName()+"��ʼս����!");
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"��������ɱ"+"["+i+"]");
		}
		System.out.println(Thread.currentThread().getName()+"ս������!");	
	}
}
