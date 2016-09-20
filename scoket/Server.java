package com.liang.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.dom4j.Branch;

/**
 * ����TCPЭ���Socketͨ��
 * ��������
 * @author Administrator
 *
 */
public class Server {
	
	public static void main(String[] args) {
		try {
			//1.����һ����������Socket����,ָ���󶨶˿�
			ServerSocket serverSocket=new ServerSocket(8080);
			Socket socket=null;
			int count=0;
			System.out.println("��������������,�ȴ��ͻ��˵�����");
			while(true){
				//2.����accept()������ʼ����,�ȴ��ͻ�������
				socket=serverSocket.accept();
				//�����߳�
				ServerThread serverThread=new ServerThread(socket);
				//�����߳�
				serverThread.start();
				count++;
				System.out.println(count);
				InetAddress address=socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
