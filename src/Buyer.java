//package Assignment2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//package Assignment2;
public class Buyer<V> extends BuyerBase<V> {
//	int sleepTime;
//	int catalogSize;
//	Lock lock;
//	Condition full;
//	Condition empty;
//	PriorityQueue<V> catalog;
//	int iteration;
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...
    	//this.sleepTime=sleepTime;
    	this.catalog=catalog;
    	//this.catalogSize=catalogSize;
    	this.empty=empty;
    	this.full=full;
//    	this.iteration=iteration;
    	this.lock=lock;
    	//System.out.println("Buyer object creates");
    }
    public void buy() throws InterruptedException {
    	//System.out.println("in buy iteration="+ this.iter);
    	try {
			this.lock.lock();
			
			while(this.catalog.isEmpty())
			{
				this.empty.await();
				//System.out.println("buyer waiting");
			}
			NodeBase<V> n= this.catalog.removeMin();
			//catalog.dequeue();
			
	            //TODO Complete the try block for consume method
	            // ...
		    System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
		  
	            n.show(); // DO NOT REMOVE (For Automated Testing)
	            // ...
	        this.full.signalAll();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
		this.lock.unlock();
	}
    }
}
