package com.liang.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * 
 * @author Administrator
 * 
 */

public class ServerThread extends Thread {
	// 和本线程相关的Socket
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
			// 按行读取客户端发过来的信息
			String info = null;
			while ((info = bf.readLine()) != null) {
				System.out.println("我是服务器,客户端说:" + info);
				// info=bf.readLine();
			}
			socket.shutdownInput();// 关闭输入流
			// 服务器端返回信息给客户端
			os = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write("欢迎你");
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
