package com.liang.collection;

import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student> {
	public String id;
	public String name;
	public Set<Course> courses;
	
	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.courses=new HashSet<Course>();
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}

}
