package multithreading;

public class LockExample {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread writer = new Thread(() -> {
            for (int i=0; i<10; i++){
                sharedData.write(i);
            }
        });

        Thread reader1 = new Thread(() -> {
            for(int i =0; i<10; i++){
                System.out.println("Reader 1 read: " + sharedData.read());
            }
        });

        Thread reader2 = new Thread(() -> {
            for (int i=0; i<10; i++){
                System.out.println("Reader 2 read: " + sharedData.read());
            }
        });

        writer.start();
        reader1.start();
        reader2.start();

    }
}
