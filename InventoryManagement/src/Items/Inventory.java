package Items;

import java.util.HashMap;

public class Inventory {

	//singleton object
	private static Inventory singleInventory;
	//Collections of all items stock
	private HashMap<String,Item> stock;
	//Item id-name mapping
	private  HashMap<String,String> itemIdNameMap;

	//private constructor
	private Inventory(){
		stock=new HashMap<String,Item>();
		itemIdNameMap=new HashMap<String,String>();
	}
	
	public synchronized static Inventory getInstance(){
		 if (singleInventory == null){
			 singleInventory = new Inventory();
		 }
	     return singleInventory;
	}
	
	/*
	 * Updates item stock quantity
	 */
	public void updateStockQunatity(String name,int quantity){
		boolean result=false;
		//Checking if item is present in inventory
		if(stock.containsKey(name)){
			result=ItemUtil.updateQuantity(stock.get(name),quantity);
		}
		
		if(result){
			System.out.println("Item quantity updated to "+stock.get(name).getQuantity());
		}else{
			System.out.println("Product "+name+" not found in inventory");
		}
	}
	
	/*
	 * Adds new item into inventory
	 */
	public boolean addNewItem(String name, Double cost,String id){
		//Checking if item is present in inventory
		if(stock.containsKey(name)){
			System.out.println(" Already in inventory");
			return false;
		}else{
			Item newItem=new Item(name,cost,id);
			stock.put(name, newItem);
			itemIdNameMap.put(newItem.getId(), name);
			System.out.println(" Added into inventory");
			return true;
		}
	}
	
	/*
	 * Given item id, this method returns name of that item
	 */
	public String getName(String id){
		if(itemIdNameMap.containsKey(id)){
			return itemIdNameMap.get(id);
		}else{
			return null;
		}
		
	}

	/*
	 * Returns cost of item if it is present in inventory
	 */
    public Double getCostOfItem(String id){
    	if(itemIdNameMap.containsKey(id)){
    		String item=itemIdNameMap.get(id);
    		return (stock.get(item)).getCost();
    	}else{
    		return null;
    	}
    		
    }
    
    /*
     * This method prints all item's id,name,cost and quantity
     */
   public void printReport(){
	   int itemsCount=stock.keySet().size();
	   stock.size();
	   if(itemsCount==0){
		   System.out.println("Inventory is empty");
	   }else{
		   for(String name:stock.keySet()){
			   Item item=stock.get(name);
			   System.out.println(item.getId()+" "+item.getName()+" "+item.getCost()+" "+
			   item.getQuantity());
		   }
	   }
   }
   
   /*
    * This method updates given item's quantity with number of items purchased
    */
   public void checkOut(String itemName,int quantity){
	   if(stock.containsKey(itemName)){
		   Item item=stock.get(itemName);
		   int quant=item.getQuantity();
		   if(quant<=0){
			   System.out.println("Stock empty");
		   }else{
			  if( ItemUtil.checkOut(item,quantity)){
				  System.out.println(" Sucessfully checked out "+" Left over quantity is "+item.getQuantity());
			  }
		   }
	   }else{
		   System.out.println(" Item not available in inventory");
	   }
   }
}
