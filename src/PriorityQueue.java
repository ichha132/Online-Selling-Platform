//package Assignment2;
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {
    	
    	this.queue=new NodeBase[capacity];
    	this.capacity=capacity;
    
    }
//    public PriorityQueue(int cs, NodeBase<V>[] q)
//    {
//    	currentSize=cs;
//    	queue=q;
//    }

    public int size() {
    	return this.currentSize;
    
    }

    public boolean isEmpty() {
    	if(this.currentSize==0)
    	{
    		return true;
    	}
    	else
    		return false;

    }
	
    public boolean isFull() {
    	if(this.currentSize==this.queue.length)
    		return true;
    	else
    		return false;

    }

    public void enqueue(Node<V> node) {
    	if(this.isFull()==false)
    	{
    		int i=this.currentSize-1;
    		while(i>=0 && this.queue[i].priority>node.priority)
    		{
    			i=i-1;
    		}
    		for(i=i+1; i<this.currentSize+1; i++)
    		{
    			NodeBase<V> n= this.queue[i];
    			this.queue[i]= node;
    			node= (Node<V>) n;
    		}
    		this.currentSize =this.currentSize+1;
    	}
    }
 
    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
    	
    	NodeBase<V> n= this.queue[0];
    	if(this.isEmpty()==false)
    	{
    	for(int i=0;i<this.currentSize-1; i++)
    	{
        		this.queue[i]=this.queue[i+1];	
    	}
    	
    	this.queue[this.currentSize-1]= null;
    	this.currentSize= this.currentSize-1;
    	}
    	return n;

// priority=1 is highest and is the first element of the array
    }
    public void add(int p, V val)
    {
    	Node<V> n= new Node(p,val);
    	this.enqueue(n);
    }
    public NodeBase<V> removeMin()
    {
    	NodeBase<V> n= this.queue[0];
    	if(this.isEmpty()==false)
    	{
    	for(int i=0;i<this.currentSize-1; i++)
    	{
        		this.queue[i]=this.queue[i+1];	
    	}
    	
    	this.queue[this.currentSize-1]= null;
    	this.currentSize= this.currentSize-1;
    	}
    	return n;
    	
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<this.currentSize; i++) {
            this.queue[i+1].show();
	}
    }
}

