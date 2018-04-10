package Items;

public class Item {

	private String id;
	private Double cost;
	private String name;
	private int quantity;
	
	public Item(String name,Double cost,String id){
		this.cost=cost;
		this.name=name;
		this.quantity=0;
		this.id=id;
	}
	
	public Item(String name,Double cost,String id,int quantity){
		this.cost=cost;
		this.name=name;
		this.quantity=quantity;
		this.id=id;
	}
	
	public Double getCost(){
		return cost;
	}
	
	public String generateId(String itemName){
		return itemName.toUpperCase();
	}
	
	public String getName(){
		return name;
	}
	 
	public String getId(){
		return id;
	}
	
	public int getQuantity(){
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
}
