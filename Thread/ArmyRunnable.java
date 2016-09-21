package com.liang.Thread;

public class ArmyRunnable implements Runnable {
	
	//volatile 保证了线程可以正确的读取其他线程写入的值
	//可见性
	volatile boolean keepRunning=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepRunning){
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"进攻对方"+"["+i+"]");
				//让出了处理资源
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"进攻结束");
	}
}
