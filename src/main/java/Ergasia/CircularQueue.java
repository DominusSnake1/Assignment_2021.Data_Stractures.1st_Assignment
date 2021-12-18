package Ergasia;
import java.util.*;
public class CircularQueue
{
      /*TODO
          deite ti na kanoume to to/thn size
          Epektasimotita KLP H ama 8a xreiastoume allh metavliti gia elements kai allh gia queue length
      */
      private int Head;//Points to the "frontmost" element in the queue
      private int Tail;//Points to the "backmost" element in the queue
      private int size;
      private ArrayList<Integer> Queue = new ArrayList<Integer>();

      //Constructor
      public CircularQueue() {
            this.Head = -1;
            this.Tail = -1;
            this.size = 0;
      }


      public void push(int Data) {

            //Condition if queue is full.
            if((Head == 0 && Tail == size - 1) || (Tail == (Head - 1) % (size - 1)))
            {
                  System.out.println("Queue is full");
            }

            //Condition for empty queue.
            else if(Head == -1)
            {
                  Head = 0;
                  Tail = 0;
                  Queue.add(Tail, Data);
                  size++;
            }

            else if (Tail == (size - 1 ) && Head != 0)
            {
                  Tail = 0;
                  Queue.set(Tail, Data);
            }

            else
            {
                  Tail = (Tail + 1);
                  //Adding a new element
                  if(Head <= Tail)
                  {
                        Queue.add(Tail, Data);
                        size++;
                  }

                  //Else updating old value
                  else
                  {
                        Queue.set(Tail, Data);
                  }
            }
      }

      public int pop()
      {
            int temp;

            // Condition for empty queue.
            isEmpty();

            temp = Queue.get(Head);

            // Condition for only one element
            if(Head == Tail)
            {
                  Head = -1;
                  Tail = -1;
            }

            else if(Head == size - 1)
            {
                  Head = 0;
            }
            else
            {
                  Head = Head + 1;
            }

            //Returns the popped element
            return temp;
      }

      public boolean isEmpty()
      {
            if(Head == -1 && Tail == -1)
            {
                  System.out.println("Queue is empty.");
                  return true;
            }
            else return false;
      }

      public int size()
      {
            if(isEmpty())
            {
                  size = 0;
            }
            else
            {
                  size = Head > Tail ? (size - Head + Tail + 1) : (Tail - Head + 1);
            }

            return size;
      }

      public void first()
      {
            if(!isEmpty())
            {
                  System.out.println("The first element is: " + Queue.get(Head));
            }
            else System.out.println("Queue is empty.");
      }

      public void clear()
      {
            this.Head = -1;
            this.Tail = -1;
            this.size = 0;
      }
}