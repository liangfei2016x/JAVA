package com.liang.scoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) {
		try {
			//1.����DatagramSoket�������󶨶˿ں�IP
			DatagramSocket socket=new DatagramSocket(8080);
			//�������ݱ�,���ڽ��ܿͻ��˷��͵�����
			byte[] data=new byte[1024];
			DatagramPacket packet=new DatagramPacket(data, data.length);
			//��������
			System.out.println("UDP�������Ѿ�����");
			socket.receive(packet);
			String string=new String(data,0,packet.getLength());
			System.out.println("���Ƿ�����,�ͻ���˵��"+string);
			//��ͻ�����Ӧ����
			InetAddress address=packet.getAddress();
			int port=packet.getPort();
			byte[] data2="��������,�ұ���Ӧ".getBytes();
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
