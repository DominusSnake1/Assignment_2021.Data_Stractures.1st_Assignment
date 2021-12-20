package Ergasia;

import java.util.Arrays;

public class CircularQueue<E> implements Queue<E> {

      public static final int INITIAL_SIZE = 64;

      private int front;                                                                                     //Points to the "frontmost" element in the queue.
      private int rear;                                                                                       //Points to the "backmost" element in the queue.
      private int current_size;                                                                        // Number of elements in the queue.
      private E[] Circular_Queue;

      //Constructor
      public CircularQueue() {
            front = -1;
            rear = -1;
            current_size = 0;
            Circular_Queue = (E[]) new Object[INITIAL_SIZE];
      }

      @Override
      public boolean isEmpty() {return current_size == 0;}

      public boolean isFull() {return (current_size >= Circular_Queue.length);}

      @Override
      public int size() {return current_size;}

      @Override
      public void push(E elem) {
            if (isFull()) {
                  doubleSize();
            }

            rear = ( (rear + 1) % Circular_Queue.length );
            Circular_Queue[rear] = elem;
            current_size++;

            //System.out.println("Added number: " + elem);
            //System.out.println("Rear is: " + rear);

            if (front == -1) {
                  front = 0;
            }
      }

      @Override
      public E pop() throws Exception {
            if (isEmpty()) {
                  throw new Exception("Queue is empty; no elements to dequeue.");
            }

            //System.out.println("Front is: " + front);
            //System.out.println("Rear is: " + rear);

            E dequeuedElement = Circular_Queue[front];
            Circular_Queue[front] = null;
            front = ( (front + 1) % Circular_Queue.length );
            current_size--;

            //System.out.println("Removed number: " + dequeuedElement);
            //System.out.println("Length is: " + Circular_Queue.length);

            if (ifQuarterFilled()) {
                  halfSize();
            }

            return dequeuedElement;
      }

      @Override
      public E first() {return Circular_Queue[front];}

      @Override
      public void clear() {
            front = -1;
            rear = -1;
            current_size = 0;
      }

      public void doubleSize() {
            //System.out.println("Duplication starts at: " + Circular_Queue.length);
            int new_length = (Circular_Queue.length * 2);
            E[] Temp_Circular_Q = (E[]) new Object[new_length];

            for (int i = 0; i < current_size; i++) {
                  Temp_Circular_Q[i] = Circular_Queue[i];
            }

            Circular_Queue = Temp_Circular_Q;

            //System.out.println("Duplication ends at: " + Circular_Queue.length);
      }

      public boolean ifQuarterFilled() {return (4 * current_size) <= Circular_Queue.length;}

      public void halfSize() {
            //System.out.println("Division starts at: " + Circular_Queue.length);
            int new_length = (Circular_Queue.length / 2);

            if (new_length % 2 != 0) {
                  new_length++;
            }

            E[] Temp_Circular_Q = (E[]) new Object[new_length];

            for (int i = front; i < (size() + front); i++) {
                  Temp_Circular_Q[i - front] = Circular_Queue[i];
            }

            Circular_Queue = Temp_Circular_Q;

            front = 0;
            rear = current_size - 1;

            //System.out.println("Division ends at: " + Circular_Queue.length);
      }

      public int getFront() {
            return front;
      }

      public int getRear() {
            return rear;
      }

      public int getCircular_QueueLength() {return Circular_Queue.length;}

      @Override
      public String toString() {
            return Arrays.toString(Circular_Queue);
      }

}