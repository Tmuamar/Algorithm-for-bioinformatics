public class BitonicTour 
{
   // calculating distance using the equation for the distance between two points
   static double distance(int i, int j, double[] x, double[] y) 
   {
      double distx = x[i] - x[j];
      double disty = y[i] - y[j];
      return Math.sqrt((distx*distx)+(disty*disty));
   }
   static void Bitonic(int n, double x[], double y[]) 
   {
      double []arr2 = new double [n-1];
      int j;
      double length;
      //stores length for later use
      double length2 = 0;
      // calculating the distance of arr2[0]
      arr2[0] = distance(0,1,x,y);
      //calculating the value iteratively by going from i=1,...,n-2
      for (int i = 1; i <= n-2; i++) 
      {
         arr2[i] = 0;
         /*So i+1 is connected to j on its left then i
          *it goes from j+1 and so on to i
          *creating the sub problem for j+1 ..0..j
          */
         for (j = 0; i<j; j++) 
         {
            length = distance(j, i+1, x, y)+ arr2[j];
         }
      }
      //this is calculating the path of the shortest length
      length = distance(n-2, n-1, x, y) + arr2[n-2];
      System.out.println("Shortest path is "+ length);
      // calculating the shortest bitonic tour length
      length = distance(0, n-1, x, y);
      for(int c=0; c<n-1; c++ ) {
         length += distance(c, c+1, x, y);
       }
      System.out.println("Shortest path is "+ length);
   }
   public static void main(String args[])
   {
      int n = 3;
      double x[] = {1,2,3};
      double y[] = {1,3,1};
      Bitonic(n, x, y); 
   }
}     