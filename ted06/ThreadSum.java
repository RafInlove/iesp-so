public class ThreadSum implements Runnable{
    private int threadId;
    private int start;
    private int end;
    private static int[] array;
    private static int sum = 0;
    private static Object lock = new Object();

    public ThreadSum(int threadId, int[] array) {
        this.threadId = threadId;
        this.array = array;
        
        int arraySize = array.length;

        this.start = threadId * (arraySize / Main.numThreads);
        this.end = threadId * (arraySize / Main.numThreads);
    }

    @Override
    public void run() {
        int localSum = 0;

        for(int i = start; i < end; i++) {
            localSum += array[i];
        }

        synchronized (lock) {
            sum += localSum;
        }
    }

    public static int getSum() {
        return sum;
    }
}
