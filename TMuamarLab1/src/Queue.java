import java.util.NoSuchElementException;

public class Queue<T>
{
   // initializing variables for queue
    private Node<?> Front;
    private Node<?> rear;
    private int n;
    
    public Queue() 
    {
       Front = null;
       rear  = null;
       n = 0;   
    }
    
    /**
     * If queue is empty returns true
     *
     * @return true if queue empty, false if queue is not empty
     */
    public boolean isEmpty() 
    {
       return Front == null;
    }
    
    /**
     * Size of the queue
     *
     * @return number of items in queue
     */
    public int size() 
    {
       return n; 
    }
    
    /**
     * returns item that is recently added in the queue
     * 
     * @return item at that has been added recently
     * 
     * @throws NoSuchElementException if this queue is empty
     */
    public <T> char peek() 
    {
       if (isEmpty()) throw new NoSuchElementException("null");
       return Front.data;    
    }
    
    /**
     * adding an data to the rear of the queue
     *
     * @param  data is added to the queue
     */
    public void enqueue(char data) 
    {
       Node<?> temp = rear;
       rear = new Node<Object>(data);
       rear.setData(data);
       rear.setNext(null);
       
       if (isEmpty()) 
       {
          Front = rear;  
       }
       else
       { 
          temp.next = rear;
       }
       n++;      
    }
    
    /**
     * deletes an item from a queue
     * 
     * @return returns the data that is deleted
     * 
     * @throws if nothing to delete then queue underflow
     */
    public char dequeue() 
    {
       if (isEmpty()) throw new NoSuchElementException("Queue underflow");
       char data = Front.data;
       Front = Front.next;
       n--;
       if (isEmpty()) 
       {
          rear = null;
       } 
       return data;
    }
}