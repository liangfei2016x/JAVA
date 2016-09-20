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
		//1.创建客户端Socket
		try {
			Socket socket=new Socket("127.0.0.1",8080);
			//2.发送信息 首先是获取输出流
		OutputStream os=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
		pw.write("用户名：Tom,密码：123");
		pw.flush(); 
		socket.shutdownOutput();//关闭输出流
		//得到服务器传过来的数据
		InputStream is=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));		
		String info=null;
		while((info=br.readLine())!=null){
			System.out.println("我是客户端,服务器说:"+info);
			//info=bf.readLine();
		}		
		//3.关闭资源
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
