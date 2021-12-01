package Ergasia;

public interface Queue<E> {

      void enQueue(E elem);

      E deQueue();

      E first();

      boolean isEmpty();

      int size();

      void clear();

}
