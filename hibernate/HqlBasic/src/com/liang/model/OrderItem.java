package com.liang.model;

import java.io.Serializable;

/**
 * ����������Ϣ
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class OrderItem implements Serializable {
	private Long id;
	private Order order;//�����ĸ�����
	//���һ��ϵ
	private Commodity commodity;//��������Ʒ
	private Double discount;//�ۿ�
	private Double actPrice;//�۸�
	private Double amount;//����
	private Integer position;//
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getActPrice() {
		return actPrice;
	}
	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
