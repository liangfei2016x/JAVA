package com.liang.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOutil {
	//一个字节一个自己读取
	public static void printHex(String filename) throws IOException{
		FileInputStream inputStream=new FileInputStream(filename);
		int  b;
		int i=1;
		while((b=inputStream.read())!=-1){
			System.out.print(Integer.toHexString(b)+"  ");
			//读十个换行
			if(i++%10==0){
				System.out.println();
			}
		}
		inputStream.close();
	}
	//批量读取 常用
	public static void printHexBytes(String filename) throws IOException{
		FileInputStream in=new FileInputStream(filename);
		byte[] buf=new byte[20*1024];
		/**
		 * 从in中批量读取字节,放到buf这个字节数组中
		 * 从第0个位置开始放,最多放buf.length个
		 * 返回的是读取的有效的字节个数
		 */
//		int bytes=in.read(buf,0,buf.length);
//		int j = 1;
//		for (int i = 0; i < bytes; i++) {
//			System.out.print(Integer.toHexString(buf[i] & 0xff)+"  ");
//			if(j++%10==0){
//				System.out.println();
//			}
//		}		
		int bytes=0;
		int j=1;
		while((bytes=in.read(buf,0,buf.length))!=-1){
			for (int i = 0; i < bytes; i++) {
			System.out.print(Integer.toHexString(buf[i] & 0xff)+"  ");
			if(j++%10==0){
				System.out.println();
			}
		}
		}	
		in.close();
	}
	public static void main(String[] args) throws IOException {
		//printHex("D:\\txt\\test.txt");
		printHexBytes("D:\\txt\\test.txt");
	}
}
 