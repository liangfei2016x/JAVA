package com.liang.Thread;

public class ArmyRunnable implements Runnable {
	
	//volatile ��֤���߳̿�����ȷ�Ķ�ȡ�����߳�д���ֵ
	//�ɼ���
	volatile boolean keepRunning=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepRunning){
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"�����Է�"+"["+i+"]");
				//�ó��˴�����Դ
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"��������");
	}
}
