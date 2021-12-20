package Ergasia;

public interface Queue<E> {

      void push(E elem) throws Exception;

      E pop() throws Exception;

      E first() throws Exception;

      boolean isEmpty();

      int size();

    abstract void clear();
}
