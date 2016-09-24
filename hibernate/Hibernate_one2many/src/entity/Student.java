package entity;

import java.io.Serializable;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements Serializable {
	// Fields
	/**
	 * 
	 */
	private Integer sid;
	private String sname;
	private String sex;
	//在多的一方引用 (1)的一方
	private Grade grade;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sname) {
		this.sname = sname;
	}
	/** full constructor */
	public Student(String sname, String sex) {
		this.sname = sname;
		this.sex = sex;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}