package Items;

public class ThreadPool {

	//Hard coded client pool size
	final static int poolSize=10;
	
	public static void main(String[] args){	
	//spun threads
     for(int i=1;i<=poolSize;i++){
		Client newClient=new Client(i+"_Thread");
		newClient.start();
	 }
	}
}