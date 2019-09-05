
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Assignment2Driver {
    static public int catalogSize;
    static public int numBuyers;
    static public int numSellers;
    static public int sellerSleepTime, buyerSleepTime;
    static public Queue<Item> inventory;
    
    public static void main(String[] args) throws InterruptedException {
	
	Assignment2Driver a_driver = new Assignment2Driver();
	BufferedReader reader;
        int itemcount = 0;
	try {
	    reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
	    ArrayList<Node<Item>> list = new ArrayList<Node<Item>>();
	    String[] tokens = line.split(" ");
	    a_driver.catalogSize = Integer.parseInt(tokens[0]);
	    a_driver.numBuyers = Integer.parseInt(tokens[1]);
	    a_driver.numSellers = Integer.parseInt(tokens[2]);
	    a_driver.buyerSleepTime = Integer.parseInt(tokens[3]);
	    a_driver.sellerSleepTime = Integer.parseInt(tokens[4]);
	    
	    while (line != null) {
		line = reader.readLine();
	    	//System.out.println(line);
		if (line != null) {
                    itemcount++;                                  	
		    tokens = line.split(" ");
		    Item item = new Item(tokens[1], Double.parseDouble(tokens[2]));
		    Node<Item> node = new Node<Item>(Integer.parseInt(tokens[0]), item);
		    list.add(node);
		    //System.out.println(node);
		}
		//line = reader.readLine();
	    }
	   // System.out.println(list.size());
//	    for(int i=0; i< list.size();i++)
//	    {
//	    	System.out.println(list.get(i).getValue());
//	    }
            a_driver.inventory = new Queue<Item>(list.size());
            for (int i=0;i<list.size();i++)
            {
            	a_driver.inventory.enqueue(list.get(i));
            }
            //TODO Add all elements of the ArrayList named "list" to inventory queue
            // ...
           
            //a_driver.inventory.printQueue();;
            
           // System.out.println("itemcount="+ itemcount);
            reader.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
	
	Seller[] sellers = new Seller[a_driver.numSellers];
	Buyer[] buyers = new Buyer[a_driver.numBuyers];
	PriorityQueue<Node<Item>> queue = new PriorityQueue<Node<Item>>(a_driver.catalogSize);
	Lock lock = new ReentrantLock();
	Condition full = lock.newCondition();
	Condition empty = lock.newCondition();
        int iteration = itemcount/a_driver.numBuyers; // No. of purchases each buyer make
        
	// TODO Create multiple Buyer and Seller Threads and start them.
        // ...
        Thread[] st= new Thread[a_driver.numSellers];
        Thread[] bt= new Thread[a_driver.numBuyers];
        for(int i=0; i<sellers.length; i++)
        {
        	sellers[i]=new Seller(sellerSleepTime, catalogSize, lock,full,empty,queue, inventory);
        	
        }
        for(int i=0; i<buyers.length; i++)
          {
          	buyers[i]=new Buyer(buyerSleepTime, catalogSize ,lock,full,empty,queue, iteration);
          	buyers[i].setIteration(iteration);
          }
        for(int i=0;i<sellers.length;i++)
        {
        	st[i]= new Thread(sellers[i]);
        	
        }
        for(int i=0;i<buyers.length;i++)
        {
        	bt[i]= new Thread(buyers[i]);
        	
        }
//        for(int i=0, j=0;i<sellers.length || j<buyers.length;i++, j++)
//        {
//        	if(i== sellers.length)
//        	{
//        		bt[j].start();
//        	}
//        	else if(j==buyers.length)
//        	{
//        		st[i].start();
//        	}
//        	else
//        	{
//        		st[i].start();
//        		bt[j].start();
//        	}
//        }
        for(int i=0; i<sellers.length;i++)
        {
        	st[i].start();
        }
        for(int i=0; i<buyers.length;i++)
        {
        	bt[i].start();
        }
//        sellers[0]=new Seller(lock,full,empty,queue, inventory);
//        buyers[0]=new Buyer(lock,full,empty,queue,iteration);
//        buyers[0].setIteration(iteration);
//        Thread st= new Thread(sellers[0]);
//        Thread bt= new Thread(buyers[0]);
//    	st.start();
//    	bt.start();
//	Buyer b1= new Buyer( buyerSleepTime,catalogSize, lock,full,empty,queue, iteration);
//	Seller s1= new Seller(sellerSleepTime, catalogSize ,lock, full, empty, queue, inventory);
//	Thread buyer= new Thread(b1);
//	Thread seller= new Thread(s1);
//	buyer.start();
//	seller.start();
    }
}
