package Ergasia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest2
{
    public CircularQueueTest2() {
    }

    @Test
    public void TestCircularQueue() throws Exception {
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
}