package com.liang.scoket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * InetAddress��
 * @author Administrator
 *
 */
public class ScoketTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress=InetAddress.getLocalHost();
		
		System.out.println("��ȡ�������:"+inetAddress.getHostName());
		System.out.println("IP:"+inetAddress.getHostAddress());
		byte[] bytes=inetAddress.getAddress();//�ֽ���ʽ��IP��ַ
		System.out.println(""+Arrays.toString(bytes));
		System.out.println(inetAddress);//ֱ�����InetAddress����
		
		//���ݼ��������ȡInetAddressʵ��
		//InetAddress inetAddress2=InetAddress.getByName("PC-20160618URMP");
		//����IP��ȡInetAddressʵ��
		InetAddress inetAddress2=InetAddress.getByName("192.168.2.107");
		System.out.println("��ȡ�������:"+inetAddress2.getHostName());
		System.out.println("IP:"+inetAddress2.getHostAddress());
		
	}
}
