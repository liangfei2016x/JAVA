package com.liang.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 客户信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Customer implements Serializable {
	private Long id;//主键
	private String name;//姓名
	private String tel;//电话
	private String address;//地址
	private String email;//邮箱
	private String sex;//性别
	private String description;//自我介绍
	private Integer age;//年龄
	private Date brithday;//生日
	public Long getId() {
		return id;
	}
	public Customer(){
		
	}
	public Customer(Long id, String name, String tel, String address,
			String email, String sex, String description, Integer age,
			Date brithday) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.sex = sex;
		this.description = description;
		this.age = age;
		this.brithday = brithday;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", address=" + address + ", email=" + email + ", sex=" + sex
				+ ", description=" + description + ", age=" + age
				+ ", brithday=" + brithday + "]";
	}
}
