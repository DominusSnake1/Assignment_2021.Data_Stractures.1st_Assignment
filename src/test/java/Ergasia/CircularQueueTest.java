package Ergasia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularQueueTest {
      public CircularQueueTest() {
      }

      @Test
      public void Test1() throws Exception {
            CircularQueue<Integer> Q = new CircularQueue<>();

            assertTrue(Q.isEmpty());

            int count = 100000;

            for (int i = 0; i < count; i++) {
                  Q.push(i);
                  assertTrue(Q.size() == i + 1);
                  assertTrue(Q.first() == 0);
            }

            int current = 0;
            while (!Q.isEmpty()) {
                  assertTrue(Q.first() == current);
                  assertTrue(Q.pop() == current);
                  current++;
            }
            assertTrue(Q.isEmpty());
      }


      @Test
      public void Test2() throws Exception {
            CircularQueue<Integer> Q = new CircularQueue<>();

            assertTrue(Q.isEmpty());

            int count = 100000;
            int PreviousLength ;
            int PreviousSize ;
            for (int i = 0; i < count; i++)
            {
                  Q.push(i);
            }

            PreviousLength = Q.getCircular_QueueLength();

            for(int i = 0; i < count; i++)
            {
                  Q.push(i);
            }
            PreviousSize = Q.size();
            assertEquals(Q.getCircular_QueueLength(), (PreviousLength * 2));
            assertFalse(Q.isFull());
            assertTrue(Q.size()!=Q.getCircular_QueueLength());
            assertFalse(Q.isEmpty());

            PreviousLength = Q.getCircular_QueueLength();
            for(int i = 0; i < count; i++)
            {
                  Q.pop();
            }
            for(int i = 0; i < (count/2); i++)
            {
                  Q.pop();
            }
            assertEquals(Q.size(), PreviousSize / 4);
            assertEquals(Q.getCircular_QueueLength(), (PreviousLength / 2));
            assertTrue(Q.size()!=Q.getCircular_QueueLength());
            for(int i = 0; i < (count/2); i++)
            {
                  Q.pop();
            }
            assertTrue(Q.isEmpty());
      }
      @Test
      public void Test3() throws Exception
      {
            CircularQueue<Integer> Q = new CircularQueue<>();

            assertTrue(Q.isEmpty());

            int count = 63;

            for (int i = 0; i < count; i++)
            {
                  Q.push(i);
            }
            Q.pop();
            Q.pop();
            Q.push(64);
            Q.push(65);

            assertEquals(0, Q.getRear());
            assertTrue(Q.getFront()>0);
            assertTrue(Q.getFront()<=64);
            assertEquals(64, Q.getCircular_QueueLength());
      }
}