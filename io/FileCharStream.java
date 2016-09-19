package com.liang.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCharStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr=new InputStreamReader(
								new FileInputStream("demo/1.txt"));
		//单char读取
//		int c;
//		while((c=isr.read())!=-1){
//			System.out.print((char)c);
//		}
//		
	//批量读取
		int c;
		char[] buffer = new char[10*1024];
		while((c=isr.read(buffer, 0, buffer.length))!=-1){
			System.out.println(buffer);
//			String string=new String(buffer,0,c);
//			System.out.println(string);
		}
		//指定编码
//		OutputStreamWriter osw=new OutputStreamWriter(
//								new FileOutputStream("demo/out.dat"),"utf-8");
		OutputStreamWriter osw=new OutputStreamWriter(
				new FileOutputStream("demo/out.dat"));
		osw.write("君生我未生,我生君已老"); 
		osw.flush();
		osw.close();
		
	}
}
