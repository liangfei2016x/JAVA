package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class Cart {
	//Map���� Items��ƷΪ��  ����Ϊֵ
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
	//����
	public boolean addGoodsInCart(Items item,int number){
		if(goods.containsKey(item)){
			goods.put(item, goods.get(item)+number);
		}else{
			goods.put(item, number);
		}
		calTotalPrice();
		return true;
	}
	//ɾ��
	public boolean removeGoodFromCart(Items item){
		goods.remove(item);
		calTotalPrice();//���¼��㹺�ﳵ�ĵ��ܼ�
		return false;
	}
	//�ܼ� 
	public double calTotalPrice(){
		double sum=0.0;
		Set<Items> keys=goods.keySet();//��ü��ļ��� ��Ʒ����Ϣ����
		Iterator<Items> it = keys.iterator();//��õ���������
		while(it.hasNext()){
			Items i=it.next();//��Ʒ
			sum +=i.getPrice()*goods.get(i); //��Ϊ����Map����,��Ʒ��ϢΪ�� ����Ϊֵ ����goods.get(i)�͵õ�����Ʒ������
		}
		this.setTotalPrice(sum);
		return getTotalPrice();
	}
	public static void main(String[] args) {
		Items i1=new Items(1,"��������Ь","����",200,500,"001.jpg");
		Items i2=new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
		Items i3=new Items(1,"��������Ь","����",200,500,"003.jpg");
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
