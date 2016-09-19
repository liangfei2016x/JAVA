package com.liang.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOutil {
	//һ���ֽ�һ���Լ���ȡ
	public static void printHex(String filename) throws IOException{
		FileInputStream inputStream=new FileInputStream(filename);
		int  b;
		int i=1;
		while((b=inputStream.read())!=-1){
			System.out.print(Integer.toHexString(b)+"  ");
			//��ʮ������
			if(i++%10==0){
				System.out.println();
			}
		}
		inputStream.close();
	}
	//������ȡ ����
	public static void printHexBytes(String filename) throws IOException{
		FileInputStream in=new FileInputStream(filename);
		byte[] buf=new byte[20*1024];
		/**
		 * ��in��������ȡ�ֽ�,�ŵ�buf����ֽ�������
		 * �ӵ�0��λ�ÿ�ʼ��,����buf.length��
		 * ���ص��Ƕ�ȡ����Ч���ֽڸ���
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
 