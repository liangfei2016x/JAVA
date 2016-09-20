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
 * 基于TCP协议的Socket通信
 * 服务器端
 * @author Administrator
 *
 */
public class Server {
	
	public static void main(String[] args) {
		try {
			//1.创建一个服务器端Socket对象,指定绑定端口
			ServerSocket serverSocket=new ServerSocket(8080);
			Socket socket=null;
			int count=0;
			System.out.println("服务器即将启动,等待客户端的连接");
			while(true){
				//2.调用accept()方法开始监听,等待客户端连接
				socket=serverSocket.accept();
				//创建线程
				ServerThread serverThread=new ServerThread(socket);
				//启动线程
				serverThread.start();
				count++;
				System.out.println(count);
				InetAddress address=socket.getInetAddress();
				System.out.println("当前客户端的IP"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
