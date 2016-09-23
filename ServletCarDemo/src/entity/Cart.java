package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class Cart {
	//Map类型 Items物品为键  数量为值
	private HashMap<Items, Integer> goods;
	private double totalPrice;
	
	public Cart(){
		goods=new HashMap<Items, Integer>();
		totalPrice=0.0;		
	}
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	//增加
	public boolean addGoodsInCart(Items item,int number){
		if(goods.containsKey(item)){
			goods.put(item, goods.get(item)+number);
		}else{
			goods.put(item, number);
		}
		calTotalPrice();
		return true;
	}
	//删除
	public boolean removeGoodFromCart(Items item){
		goods.remove(item);
		calTotalPrice();//从新计算购物车的的总价
		return false;
	}
	//总价 
	public double calTotalPrice(){
		double sum=0.0;
		Set<Items> keys=goods.keySet();//获得键的集合 商品的信息集合
		Iterator<Items> it = keys.iterator();//获得迭代器对象
		while(it.hasNext()){
			Items i=it.next();//商品
			sum +=i.getPrice()*goods.get(i); //因为它是Map类型,商品信息为键 数量为值 所以goods.get(i)就得到了商品的数量
		}
		this.setTotalPrice(sum);
		return getTotalPrice();
	}
	public static void main(String[] args) {
		Items i1=new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
		Items i2=new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
		Items i3=new Items(1,"沃特篮球鞋","广州",200,500,"003.jpg");
		Cart c=new Cart();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		c.addGoodsInCart(i3, 3);
		//
		Set<Entry<Items, Integer>> items=c.getGoods().entrySet();
		for (Entry<Items, Integer> obj : items) {
			System.out.println(obj.getKey());
			System.out.println(obj.getValue());
		}
		System.out.println(c.getTotalPrice());
	}
}
