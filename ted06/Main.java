public class Main {

    public static int numThreads = 3;

    public static void main(String[] args) { 
        int[] array = {
            10, 19, 8, 77, 15, 95, 12, 34, 71, 42,
            45, 98, 14, 18, 91, 73, 89, 26, 90, 12
        };

        ThreadSum ts = new ThreadSum(numThreads,array);

        ts.run();
        System.out.println(ThreadSum.getSum());
    }
}
