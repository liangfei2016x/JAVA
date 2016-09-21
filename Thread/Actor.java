package com.liang.Thread;

//继承Thread
public class Actor extends Thread {
	public void run(){
		System.out.println(getName()+"是一个演员");
		int count=0;
		while(true){
			System.out.println(getName()+"演出"+(++count)+"次");
			if(count==100) {
				break;
			}
			if(count%10==0){
				try {
					//休眠
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		System.out.println(getName()+"演出结束");
	}
	public static void main(String[] args) {
		//父类指向子类 让Actor 拥有了线程的属性和方法 
		Thread actor=new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		Thread actress=new Thread(new Actress(),"Mrs.Runable");
		actress.start();
	}		
}
class Actress implements Runnable{

	public void run(){
		System.out.println(getName()+"是一个演员");
		int count=0;
		while(true){
			System.out.println(getName()+"演出"+(++count)+"次");
			if(count==100) {
				break;
			}
			if(count%10==0){
				try {
					//休眠
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		System.out.println(getName()+"演出结束");
	}
	//获得线程名字
	private String getName() {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}
	
}

