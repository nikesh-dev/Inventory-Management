package Items;

public class ItemUtil {

	
	public static boolean updateQuantity(Item item,int newQuantity){
		//To maintain atomicity at object level
		synchronized(item)
        {
	       item.setQuantity(item.getQuantity()+newQuantity);
		   return true;
        }
	}
	
	public static boolean checkOut(Item item,int checkOutQuantity){
		//To maintain atomicity at object level
		synchronized(item)
        {
		  if(checkOutQuantity<=item.getQuantity()){
			item.setQuantity(item.getQuantity()-checkOutQuantity);
			return true;
		  }else{
			return false;
		  }
        }
	}
}