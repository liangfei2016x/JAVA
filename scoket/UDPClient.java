package com.liang.scoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {
	public static void main(String[] args) throws IOException {
		//����������ĵ�ַ���˿ںš�����
		InetAddress address=InetAddress.getByName("127.0.0.1");
		int port=8080;
		byte[] data="�û�����admin,���룺123".getBytes();
		//��װ����    ��������data ���ݵĴ�Сdata.length  ���͵����� address,port
		DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
		//����socket����
		DatagramSocket socket=new DatagramSocket();
		//��������˷�������
		socket.send(packet);
		//�������ݱ�,���ܷ�������Ӧ������
		byte[] data2=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(data2, data2.length);
		//���ܷ�������Ӧ������
		socket.receive(packet2);
		//��ȡ����
		String data3=new String(data2, 0, packet.getLength());
		System.out.println("UDP��������Ӧ˵:"+data3);
		socket.close();
	}
}
