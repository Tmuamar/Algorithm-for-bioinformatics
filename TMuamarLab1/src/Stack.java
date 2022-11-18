/* using a queue to implements a stack by pushing items in q1 to q2 then 
 * swapping the queue names. 
 */

import java.util.NoSuchElementException;

public class Stack<T>
{
   // initializing two queues to allow for a stack implementation
   Queue<Object> firstQ = new Queue<Object>();
   Queue<Object> secondQ = new Queue<Object>();
   int currentSize;
   
   public Stack()
   {
      currentSize = 0; 
   }
   
   /**
    * pushes element p on to the stack
    * 
    * @param p characters that are pushed on to the stack
    * 
    */
   public void push (char p) 
   {
      currentSize++;
      secondQ.enqueue(p);                                              
      while(!firstQ.isEmpty()) 
      {
         secondQ.enqueue(firstQ.peek());
         firstQ.dequeue(); 
      }
      Queue<?> temp = firstQ;
      firstQ = secondQ;
      secondQ = (Queue<Object>) temp;  
   }
   
   /**
    * this deletes an item from the stack
    * 
    * @return returns the item that has been deleted from the stack
    * @throws if the queue is empty returns  an error that there is nothing to delete
    */
   public char pop()
   {
      if(firstQ.isEmpty()) 
      { 
         throw new NoSuchElementException("Stack underflow");
      }
      currentSize--;
      return firstQ.dequeue();
   }
   
   // if the stack is empty then return true else returns false if queue is not empty
   boolean Empty() 
   {
      return (firstQ.isEmpty() & secondQ.isEmpty());
      
   }
   
}

  
