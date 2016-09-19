package com.liang.io;

import java.io.File;
import java.io.IOException;

//列出File的一些常用操作比如 过滤 遍历
public class FileUtil {
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录:"+dir+"不存在");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录");
		}
//		String[] fileNames = dir.list();
//		for(String name:fileNames){
//			//列出文件 不包括子目录的 文件
//			System.out.println(dir+"\\"+name);
//		}
		//如果要遍历子目录下的内容
		File[] files=dir.listFiles();
		if(files !=null && files.length>0){
			for(File file:files){
				if(file.isDirectory()){
					listDirectory(file);//递归
				}else{
					System.out.println(file);
				}
			}	
		}

	}
	public static void main(String[] args) throws IOException {
		listDirectory(new File("D:\\shuju"));
	}

}
