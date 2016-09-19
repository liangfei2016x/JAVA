package com.liang.io;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private String sID;
	private String sName;
	private int sAage;
	public Student(){
	}
	//构造方法
	public Student(String sID, String sName, int sAage) {
		super();
		this.sID = sID;
		this.sName = sName;
		this.sAage = sAage;
	}
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAage() {
		return sAage;
	}
	public void setsAage(int sAage) {
		this.sAage = sAage;
	}
	@Override
	public String toString() {
		return "Student [sID=" + sID + ", sName=" + sName + ", sAage=" + sAage+ "]";
	}	
}
