package com.liang.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	/**
	 * URL���÷���
	 * @param args
	 */
	public static void bdurl(){
		//��ץ����ҳ�档����
		try {
			URL url=new URL("http://www.baidu.com");
			//��ȡ�ֽ�������
			InputStream in=url.openStream();
			//�ֽ�������ת�����ַ�������
			//InputStreamReader isr=new InputStreamReader(in,"utf-8");
			//Ϊ�ַ���������ӻ���
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
		//����
		bdurl();						
//		try {
//			//����һ��URLʵ��
//			URL url=new URL("http://www.imooc.com/");
//			URL url2=new URL(url,"/index.html?username=tom?#test");
//			System.out.println("Э��:"+url.getProtocol());
//			System.out.println("������"+url.getHost());
//			System.out.println("�˿�:"+url.getPort());
//			System.out.println("�ļ���"+url2.getFile());
//			System.out.println("�ļ�·��"+url2.getPath());
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
