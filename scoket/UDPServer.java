package com.liang.scoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) {
		try {
			//1.创建DatagramSoket对象来绑定端口和IP
			DatagramSocket socket=new DatagramSocket(8080);
			//创建数据报,用于接受客户端发送的数据
			byte[] data=new byte[1024];
			DatagramPacket packet=new DatagramPacket(data, data.length);
			//接受数据
			System.out.println("UDP服务器已经启动");
			socket.receive(packet);
			String string=new String(data,0,packet.getLength());
			System.out.println("我是服务器,客户端说："+string);
			//向客户端响应数据
			InetAddress address=packet.getAddress();
			int port=packet.getPort();
			byte[] data2="你若连接,我必响应".getBytes();
			DatagramPacket packet2=new DatagramPacket(data2, data2.length,address,port);
			socket.send(packet2);
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
