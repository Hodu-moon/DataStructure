import _06_LinkedListQueue.LinkedListQueue;

public class Main {

    public static void main(String[] args) {
        LinkedListQueue<Integer> a = new LinkedListQueue<>();

        System.out.println("offer");
        for(int i = 0; i < 16; i++){
            a.offer(i);
        }

        for(int i = 0; i < 16; i++){
            System.out.print(a.poll());
        }

        for(int i = 0; i < 33; i++){
            a.offer(i);
        }

        for(int i = 0; i < 16; i++){
            System.out.print(a.poll());
        }
    }
}