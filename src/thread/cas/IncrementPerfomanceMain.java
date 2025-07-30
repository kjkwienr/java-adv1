package thread.cas;

public class IncrementPerfomanceMain {

    private final static int COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger){
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }
        long end = System.currentTimeMillis();
        System.out.println("time ms = " + (end - start));
    }
}
