Class PriorityQueue<V> implements QueueInterface <V>
1) a parameterized constructor :- which assigns the values to capacity of the queue and sets the size of the queue
2) size() :- returns the size of the queue
3) isEmpty() :- returns true if the queue is empty else false 
4) isFull() :- return true if the queue is full else false 
5) enqueue(Node<V>) :- will add that node to the queue at the correct location with respect to its priority 
6) dequeue ():- removes element with least priority 
7) add(int, V):-  adds element with that priority and that value to the queue 
8) removeMin() :- removed element with least priority from the queue 
9) display ():- prints the queue 


Class Queue <V> implements QueueInterface<V>
1)  parameterized constructor:- assigns value to the capacity and length to the queue
2) size() :- returns the size of the queue
3) isEmpty() :- returns true if the queue is empty else false 
4) isFull() :- return true if the queue is full else false
5) enqueue (Node <V>) :- adds node to the end of the queue 
6) dequeue():- removed node from the start of the queue 
7) removeMin():- removes elements with least priority
8) add(int, V) :- adds node with that priority and that Val in the queue 
9) printQueue():- prints all nodes of the queue in separate lines 


Class Queue Node extends NodeBase<V>
1) parameterized constructor:- assigns value to priority and value 
2) getPriority():- returns the priority of the node 
3) getValue():- returns value of the node 


Class Seller<V> extends SellerBase<V>
1) constructor:- assigns values to catalog, lock,empty, full, inventory 
2) sell() :- removes an item from the inventory and puts it in the catalog , if the catalog is not full, for the buyers to buy it . If the catalog is full, seller waits till when signalled from the buyer.


Class Buyer<V> extends BuyerBase<V>
1) parameterized constructor:- assigns values to catalog, empty, full, lock
2) buy ():- removes item of highest priority from the catalog if the catalog is not empty . If the catalog is empty , buyer waits until when signalled from the seller.




Class Assignment2Driver
1) main function:- reads the input file and fills the inventory. Creates objects of buyer and seller class depending on the number of buyers and sellers. Creates a catalog called queue 
Creates threads for each buyer and each seller.
Run () function of buyer and seller is called and code is implemented. 


All functions and classes are compiled and run correctly.