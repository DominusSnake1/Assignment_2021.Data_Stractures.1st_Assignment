package Ergasia;

import java.util.Arrays;

public class CircularQueue<E> implements Queue<E> {

      public static final int INITIAL_SIZE = 12;

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

            System.out.println("Added number: " + elem);
            System.out.println("Rear is: " + rear);
            if (front == -1) {
                  front = 0;
            }
      }

      @Override
      public E pop() throws Exception {
            if (isEmpty()) {
                  throw new Exception("Queue is empty; no elements to dequeue.");
            }

            E dequeuedElement = Circular_Queue[front];
            Circular_Queue[front] = null;
            front = ( (front + 1) % Circular_Queue.length );
            current_size--;

            System.out.println("Removed number: " + dequeuedElement);
            System.out.println("Front is: " + front);
            System.out.println("Rear is: " + rear);
            System.out.println("Length is: " + Circular_Queue.length);
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
            System.out.println("Duplication starts at: " + Circular_Queue.length);
            int new_length = (Circular_Queue.length * 2);
            E[] Temp_Circular_Q = (E[]) new Object[new_length];

            for (int i = 0; i < current_size; i++) {
                  Temp_Circular_Q[i] = Circular_Queue[i];
            }

            Circular_Queue = Temp_Circular_Q;

            System.out.println("Duplication ends at: " + Circular_Queue.length);
      }

      public boolean ifQuarterFilled() {return (4 * current_size) < Circular_Queue.length;}

      public void halfSize() {
            System.out.println("Division starts at: " + Circular_Queue.length);
            int new_length = (Circular_Queue.length / 2);
            E[] Temp_Circular_Q = (E[]) new Object[new_length];

            for (int i = front; i < (size() + front); i++) {
                  Temp_Circular_Q[i - front] = Circular_Queue[i];
            }

            Circular_Queue = Temp_Circular_Q;

            front = ( (front)  % Circular_Queue.length );
            rear = ( (rear ) % Circular_Queue.length );

            System.out.println("Division ends at: " + Circular_Queue.length);
      }

      public String toString() {
            return Arrays.toString(Circular_Queue);
      }


      public static void main(String[] args) throws Exception {
            CircularQueue<Integer> Q = new CircularQueue<>();

            System.out.println("Elements in Q: " + Q.current_size);
            System.out.println(Q);

            Q.push(10);
            System.out.println(Q);
            Q.push(11);
            System.out.println(Q);
            Q.push(12);
            System.out.println(Q);
            Q.push(13);
            System.out.println(Q);
            Q.push(14);
            System.out.println(Q);
            Q.push(15);
            System.out.println(Q);
            Q.push(16);
            System.out.println(Q);

            System.out.println("Elements in Q: " + Q.current_size);
            System.out.println(Q);

            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);

            System.out.println("Elements in Q: " + Q.current_size);

      }
}