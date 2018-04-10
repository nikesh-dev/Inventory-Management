package Items;

public class Client extends Thread{

	Client(String threadName){
		super(threadName);
	}
	
	@Override
	public  void run(){
		Inventory inventory=Inventory.getInstance();
		inventory.addNewItem("pepsi", 12.5, "1");
		inventory.updateStockQunatity("pepsi", 100);
		inventory.checkOut("pepsi", 1);
		inventory.printReport();
	}
}
