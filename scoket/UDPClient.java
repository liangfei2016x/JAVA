package com.liang.scoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {
	public static void main(String[] args) throws IOException {
		//定义服务器的地址、端口号、数据
		InetAddress address=InetAddress.getByName("127.0.0.1");
		int port=8080;
		byte[] data="用户名：admin,密码：123".getBytes();
		//包装数据    发送数据data 数据的大小data.length  发送到哪里 address,port
		DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
		//创建socket对象
		DatagramSocket socket=new DatagramSocket();
		//向服务器端发送数据
		socket.send(packet);
		//创建数据报,接受服务器响应的数据
		byte[] data2=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(data2, data2.length);
		//接受服务器响应的数据
		socket.receive(packet2);
		//读取出来
		String data3=new String(data2, 0, packet.getLength());
		System.out.println("UDP服务器响应说:"+data3);
		socket.close();
	}
}
