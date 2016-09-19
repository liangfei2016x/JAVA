package com.liang.io;

import java.io.File;
import java.io.IOException;

//�г�File��һЩ���ò������� ���� ����
public class FileUtil {
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Ŀ¼:"+dir+"������");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"����Ŀ¼");
		}
//		String[] fileNames = dir.list();
//		for(String name:fileNames){
//			//�г��ļ� ��������Ŀ¼�� �ļ�
//			System.out.println(dir+"\\"+name);
//		}
		//���Ҫ������Ŀ¼�µ�����
		File[] files=dir.listFiles();
		if(files !=null && files.length>0){
			for(File file:files){
				if(file.isDirectory()){
					listDirectory(file);//�ݹ�
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
