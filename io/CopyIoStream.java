package com.liang.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyIoStream {

	/**���û������������ļ�
	 * @param args
	 * @throws IOException 
	 */
	public static void copyFileBuffer(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ�:"+srcFile+"������");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		BufferedInputStream bfinput=new BufferedInputStream(
										new FileInputStream(srcFile));
		BufferedOutputStream bfouput=new BufferedOutputStream(
										new FileOutputStream(destFile));
		int c;
		while((c=bfinput.read())!=-1){
			bfouput.write(c);
			bfouput.flush();//��ˢ
		}
		bfinput.close();
		bfouput.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		String srcFile="demo/1.txt";
		String destFile="demo/2.txt";
		long start=System.currentTimeMillis();
		copyFileBuffer(new File(srcFile), new File(destFile));		
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

}
