package com.liang.io;


import java.io.FileOutputStream;
import java.io.IOException;

public class FileOut {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//true ׷������
		FileOutputStream out= new FileOutputStream("demo/1.txt",true);
		out.write('C');//д����A�ĵͰ�λ
		String s="���Ǿ���,˭֪����.";
		byte[] gbk=s.getBytes("gbk");
		out.write(gbk);
		out.close();
		IOutil.printHex("demo/1.txt");
	}
}
