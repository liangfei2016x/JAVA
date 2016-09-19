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
		//采用utf-8编码写出 三个字节
		dos.writeUTF("我是警察,谁知道呢.");
		//采用utf-16be 编码 占俩个字节
		dos.writeChars("中国");
		IOutil.printHex(file);
	}

}
