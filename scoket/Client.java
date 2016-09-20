package com.liang.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.dom4j.io.OutputFormat;

public class Client {
	public static void main(String[] args) {
		//1.�����ͻ���Socket
		try {
			Socket socket=new Socket("127.0.0.1",8080);
			//2.������Ϣ �����ǻ�ȡ�����
		OutputStream os=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(os);//���������װΪ��ӡ��
		pw.write("�û�����Tom,���룺123");
		pw.flush(); 
		socket.shutdownOutput();//�ر������
		//�õ�������������������
		InputStream is=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));		
		String info=null;
		while((info=br.readLine())!=null){
			System.out.println("���ǿͻ���,������˵:"+info);
			//info=bf.readLine();
		}		
		//3.�ر���Դ
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
