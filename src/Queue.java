// This class implements the Queue
//package Assignment2;
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) {    
    	this.queue= new NodeBase[capacity];
    	this.capacity=capacity;
    
    }
//    public Queue(int cs, int front,int rear, NodeBase<V>[] q)
//    {
//    	queue=q;
//    	this.front=front;
//    	this.rear=rear;
//    	currentSize=cs;
//    }

    public int size() {
    	//currentSize=rear-front+1;   //front=0, rear= last index with element
    	return this.currentSize;
    
    }

    public boolean isEmpty() {
    	if(this.currentSize==0)
    		return true;
    	else
    		return false;
    
    }
	
    public boolean isFull() {
    	if(this.currentSize==this.capacity)
    		return true;
    	else
    		return false;
    
    }

    public void enqueue(Node<V> node) {
    	if(this.isFull()==false)
    	{
    		this.queue[currentSize]=node;
    		this.currentSize =this.currentSize+1;
    	}
    }

    public NodeBase<V> dequeue() {
    	NodeBase<V> n= this.queue[0];
//    	for(int i=0;i<currentSize;i++)
//    	{
//    		queue[i]=queue[i+1];
//    	}
//    	currentSize=currentSize-1;
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
    public void add(int p, V val)
    {
    	Node<V> n= new Node<V>(p,val);
    	this.enqueue(n);
    }
    public void printQueue()
    {
    	for(int i=0; i<this.currentSize; i++)
    	{
    		System.out.println(this.queue[i]);
    	}
    }

}

