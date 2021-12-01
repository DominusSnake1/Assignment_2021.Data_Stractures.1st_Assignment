package Ergasia;

public class App {

      public static void main(String[] args) {

            Queue<Integer> q = new LinkedQueue<>();

            for (int i = 0; i < 100; i++) {
                  System.out.println("Adding element " + i + " to queue");
                  q.enQueue(i);
            }

            while (!q.isEmpty()) {
                  System.out.println("Next element served from queue: " + q.deQueue());
            }
      }
}
