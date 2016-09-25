package com.liang.model;

import java.io.Serializable;

/**
 * 订单详情信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class OrderItem implements Serializable {
	private Long id;
	private Order order;//属于哪个订单
	//多对一关系
	private Commodity commodity;//订单的商品
	private Double discount;//折扣
	private Double actPrice;//价格
	private Double amount;//数量
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
