package com.liang.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class RafDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File demo=new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		File file=new File(demo,"1.txt");
		if (!file.exists()){
			file.createNewFile();
		}
		RandomAccessFile raf=new RandomAccessFile(file, "rw");
		System.out.println(raf.getFilePointer());
		raf.write('A');//这是个字符,此时只写了一个字节进去
		System.out.println(raf.getFilePointer());
		raf.write('B');
		
		String s="中";
		//转换成GBK的byte类型
		byte[] gbk=s.getBytes("gbk");
		raf.write(gbk);
		System.out.println(raf.length());
		//读文件
		raf.seek(0);
		byte[] buf=new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
	}

}
