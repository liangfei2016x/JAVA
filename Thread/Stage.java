package com.liang.Thread;

public class Stage extends Thread {
	
	
	public void run(){
		System.out.println("战争开始");
		//stage线程休眠
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//创建 俩个Runnable对象		
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
		//使用Runnable对象 创建线程
		Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"农民起义军");
		//启动线程
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//stage线程休眠
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			armyOfRevolt.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("正当双方激战正酣,半路杀出了个程咬金");
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("程咬金");
		//停止线程的方法
		armyTaskOfSuiDynasty.keepRunning=false;
		armyTaskOfRevolt.keepRunning=false;
		//也是线程停止的方法 不推荐是使用
//		armyOfSuiDynasty.stop();
//		armyOfRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mrCheng.start();
		try {
			//此方法会使其他线程等待 直至到结束
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("战争结束");
		
	}
	public static void main(String[] args) {
		new Stage().start();
	}

}
