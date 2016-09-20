package com.liang.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	/**
	 * URL常用方法
	 * @param args
	 */
	public static void bdurl(){
		//你抓个网页真。。。
		try {
			URL url=new URL("http://www.baidu.com");
			//获取字节输入流
			InputStream in=url.openStream();
			//字节输入流转换成字符输入流
			//InputStreamReader isr=new InputStreamReader(in,"utf-8");
			//为字符输入流添加缓冲
			BufferedReader br=new BufferedReader(new InputStreamReader(in,"utf-8"));
			String data=br.readLine();
			while(data!=null){
				System.out.println(data);
				data=br.readLine();
			}
			br.close();
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//调用
		bdurl();						
//		try {
//			//创建一个URL实例
//			URL url=new URL("http://www.imooc.com/");
//			URL url2=new URL(url,"/index.html?username=tom?#test");
//			System.out.println("协议:"+url.getProtocol());
//			System.out.println("主机："+url.getHost());
//			System.out.println("端口:"+url.getPort());
//			System.out.println("文件名"+url2.getFile());
//			System.out.println("文件路径"+url2.getPath());
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
