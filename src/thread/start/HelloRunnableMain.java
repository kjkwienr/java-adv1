package thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");
        HelloRunnable helloRunable = new HelloRunnable();
        Thread thread = new Thread(helloRunable);
        thread.start();

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
