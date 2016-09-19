package com.liang.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyIoStream {

	/**利用缓冲流来复制文件
	 * @param args
	 * @throws IOException 
	 */
	public static void copyFileBuffer(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		BufferedInputStream bfinput=new BufferedInputStream(
										new FileInputStream(srcFile));
		BufferedOutputStream bfouput=new BufferedOutputStream(
										new FileOutputStream(destFile));
		int c;
		while((c=bfinput.read())!=-1){
			bfouput.write(c);
			bfouput.flush();//冲刷
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
