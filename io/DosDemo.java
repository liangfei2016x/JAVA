package com.liang.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file="demo/out.dat";
		DataOutputStream dos=new DataOutputStream(
								new FileOutputStream(file));
		//����utf-8����д�� �����ֽ�
		dos.writeUTF("���Ǿ���,˭֪����.");
		//����utf-16be ���� ռ�����ֽ�
		dos.writeChars("�й�");
		IOutil.printHex(file);
	}

}
