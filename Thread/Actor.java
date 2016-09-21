package com.liang.Thread;

//�̳�Thread
public class Actor extends Thread {
	public void run(){
		System.out.println(getName()+"��һ����Ա");
		int count=0;
		while(true){
			System.out.println(getName()+"�ݳ�"+(++count)+"��");
			if(count==100) {
				break;
			}
			if(count%10==0){
				try {
					//����
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		System.out.println(getName()+"�ݳ�����");
	}
	public static void main(String[] args) {
		//����ָ������ ��Actor ӵ�����̵߳����Ժͷ��� 
		Thread actor=new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		Thread actress=new Thread(new Actress(),"Mrs.Runable");
		actress.start();
	}		
}
class Actress implements Runnable{

	public void run(){
		System.out.println(getName()+"��һ����Ա");
		int count=0;
		while(true){
			System.out.println(getName()+"�ݳ�"+(++count)+"��");
			if(count==100) {
				break;
			}
			if(count%10==0){
				try {
					//����
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		System.out.println(getName()+"�ݳ�����");
	}
	//����߳�����
	private String getName() {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}
	
}

