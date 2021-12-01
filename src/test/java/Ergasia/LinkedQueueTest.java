package Ergasia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {

      public LinkedQueueTest() {
      }

      @Test
      public void testLinkedQueue() {
            Queue<Integer> q = new LinkedQueue<>();

            assertTrue(q.isEmpty());

            int count = 100000;

            for (int i = 0; i < count; i++) {
                  q.enQueue(i);
                  assertTrue(q.size() == i + 1);
                  assertTrue(q.first() == 0);
            }

            int current = 0;
            while (!q.isEmpty()) {
                  assertTrue(q.first() == current);
                  assertTrue(q.deQueue() == current);
                  current++;
            }

            assertTrue(q.isEmpty());
      }

}