package com.liang.io;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DisDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file="demo/out.dat";
		//读出文件内容
		
		DataInputStream dis=new DataInputStream(
								new FileInputStream(file));
		String string=dis.readUTF();
		System.out.println(string);
		dis.close();
	}

}
