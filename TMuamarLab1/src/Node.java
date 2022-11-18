/*this class intializes the Node for the Queue class to store the entries 
 * 
 */
public class Node<T>
{
   char data;
   Node<?> next;
   public Node(char data)
   {
      this.data = data;
      next = null;
   }
   public char getData() 
   {
      return data;
   }
   public void setData(char data) 
   {
      this.data = data;
   }
   public Node<?> getNext() 
   {
      return next;
   }
   public void  setNext(Node<?> next) 
   {
      this.next = next;
   }
}