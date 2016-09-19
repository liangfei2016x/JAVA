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
		//true 追加内容
		FileOutputStream out= new FileOutputStream("demo/1.txt",true);
		out.write('C');//写出了A的低八位
		String s="我是警察,谁知道呢.";
		byte[] gbk=s.getBytes("gbk");
		out.write(gbk);
		out.close();
		IOutil.printHex("demo/1.txt");
	}
}
