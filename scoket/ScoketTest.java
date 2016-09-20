package com.liang.scoket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * InetAddress类
 * @author Administrator
 *
 */
public class ScoketTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress=InetAddress.getLocalHost();
		
		System.out.println("获取计算机名:"+inetAddress.getHostName());
		System.out.println("IP:"+inetAddress.getHostAddress());
		byte[] bytes=inetAddress.getAddress();//字节形式的IP地址
		System.out.println(""+Arrays.toString(bytes));
		System.out.println(inetAddress);//直接输出InetAddress对象
		
		//根据计算机名获取InetAddress实例
		//InetAddress inetAddress2=InetAddress.getByName("PC-20160618URMP");
		//根据IP获取InetAddress实例
		InetAddress inetAddress2=InetAddress.getByName("192.168.2.107");
		System.out.println("获取计算机名:"+inetAddress2.getHostName());
		System.out.println("IP:"+inetAddress2.getHostAddress());
		
	}
}
