package com.liang.Thread;

public class Stage extends Thread {
	
	
	public void run(){
		System.out.println("ս����ʼ");
		//stage�߳�����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//���� ����Runnable����		
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
		//ʹ��Runnable���� �����߳�
		Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"ũ�������");
		//�����߳�
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//stage�߳�����
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
		System.out.println("����˫����ս����,��·ɱ���˸���ҧ��");
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		//ֹͣ�̵߳ķ���
		armyTaskOfSuiDynasty.keepRunning=false;
		armyTaskOfRevolt.keepRunning=false;
		//Ҳ���߳�ֹͣ�ķ��� ���Ƽ���ʹ��
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
			//�˷�����ʹ�����̵߳ȴ� ֱ��������
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ս������");
		
	}
	public static void main(String[] args) {
		new Stage().start();
	}

}
