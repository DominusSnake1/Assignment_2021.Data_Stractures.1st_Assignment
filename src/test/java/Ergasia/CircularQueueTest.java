package Ergasia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularQueueTest {

      public CircularQueueTest() {
      }

      @Test
      public void TestCircularQueue() throws Exception {
            CircularQueue<Integer> Q = new CircularQueue<>();

            assertTrue(Q.isEmpty());

            int count = 10;

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
}