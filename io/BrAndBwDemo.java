package com.liang.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//���Զ�һ��
		BufferedReader bf=new BufferedReader(
							new InputStreamReader(
									new FileInputStream("demo/2.txt")));
		BufferedWriter bw=new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream("demo/3.txt")));
		//��һ��д��
		PrintWriter pw=new PrintWriter("");
		//����ΪString����
		String line;
		while((line=bf.readLine())!=null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		bf.close();
		bw.close();
	}
}
