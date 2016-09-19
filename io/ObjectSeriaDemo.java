package com.liang.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSeriaDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String file="demo/obj.dat";
		
//		ObjectOutputStream oos=new ObjectOutputStream(
//									new FileOutputStream(file));
//		Student stu=new Student("1","张三",11);
//		oos.writeObject(stu);//序列化对象
//		oos.flush();
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(
									new FileInputStream("demo/obj.dat"));
		Student stu=(Student)ois.readObject();
		System.out.println(stu);
		ois.close();
	}

}
