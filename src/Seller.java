//package Assignment2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//package Assignment2;
public class Seller<V> extends SellerBase<V> {
//	int sleepTime;
//	int catalogSize;
//	Lock lock;
//	Condition full;
//	Condition empty;
//	PriorityQueue<V> catalog;
//	Queue<V> inventory;
	int k=0;
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...
    	//this.sleepTime=sleepTime;
    	this.catalog=catalog;
    	//this.catalogSize=catalogSize;
    	this.empty=empty;
    	this.full=full;
    	this.lock=lock;
    	this.inventory=inventory;
    	
    }
    
    public void sell() throws InterruptedException {
    	this.lock.lock();
	try {

		NodeBase<V> n= this.inventory.removeMin();
		while(this.catalog.isFull()) {
			//System.out.println("seller waiting");
			this.full.await();
			
		}
		
		k=k+1;
		//NodeBase<V> n= this.inventory.removeMin();
		this.catalog.enqueue((Node<V>) n);
		//System.out.println(n);
		//System.out.println("line 38 of seller");
		this.empty.signalAll();
            //TODO Complete the try block for produce method
            // ...
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
		this.lock.unlock();
//		try {
//		lock.unlock();
//		}catch(IllegalMonitorStateException e) {
//			System.out.print("Got ISE");
//			System.exit(1);
//		}
            //TODO Complete this block
	}		
    }
}
