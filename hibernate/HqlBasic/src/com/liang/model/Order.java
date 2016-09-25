package com.liang.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * ������Ϣ
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Order implements Serializable{
	private Long id;
	//�������  ���һ��ϵ
	private Customer customer;//�ͻ�
	private Date tradeDate;//��������
	private String status;//����״̬
	private Double amount;//�������
	//������� һ�Զ��ϵ
	private Set<OrderItem> orderItems;//������ϸ
	public Order(){
		
	}
	public Order(Customer customer, Date tradeDate, String status, Double amount) {
		this.customer = customer;
		this.tradeDate = tradeDate;
		this.status = status;
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", tradeDate="
				+ tradeDate + ", status=" + status + ", amount=" + amount
				+ ", orderItems=" + orderItems + "]";
	}
	
}
