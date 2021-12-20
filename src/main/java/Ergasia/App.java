package Ergasia;

public class App {

      public static void main(String[] args) throws Exception {
            CircularQueue<Integer> Q = new CircularQueue<>();

            System.out.println(Q);

            Q.push(10);
            System.out.println(Q);
            Q.push(11);
            System.out.println(Q);
            Q.push(12);
            System.out.println(Q);
            Q.push(13);
            System.out.println(Q);


            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);


            Q.push(14);
            System.out.println(Q);
            Q.push(15);
            System.out.println(Q);


            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
            Q.pop();
            System.out.println(Q);
      }
}
