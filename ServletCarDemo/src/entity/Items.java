package entity;

public class Items {
	private int id;
	private String name;
	private String city;
	private int price;
	private int number;
	private String picture;
	
	public Items(){
		
	}
	
	public Items(int id, String name, String city, int price, int number,
			String picture) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj){
			return true;
		}
		if(this instanceof Items){
			Items i=(Items) obj;
			if(this.getId()==i.getId()&&this.getName().equals(i.getName())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getId()+this.getName().hashCode();
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", city=" + city
				+ ", price=" + price + ", number=" + number + ", picture="
				+ picture + "]";
	}
	

}
