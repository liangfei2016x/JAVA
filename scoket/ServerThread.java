package com.liang.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
 * 
 * @author Administrator
 * 
 */

public class ServerThread extends Thread {
	// �ͱ��߳���ص�Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader bf = null;
		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			bf = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// ���ж�ȡ�ͻ��˷���������Ϣ
			String info = null;
			while ((info = bf.readLine()) != null) {
				System.out.println("���Ƿ�����,�ͻ���˵:" + info);
				// info=bf.readLine();
			}
			socket.shutdownInput();// �ر�������
			// �������˷�����Ϣ���ͻ���
			os = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write("��ӭ��");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (os != null)
					os.close();
				if (bf != null)
					bf.close();
				if (socket != null)
					socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}

}
