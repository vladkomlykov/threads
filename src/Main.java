public class Main {
    public static void main(String[] args) throws InterruptedException {

        Fibonacci fibonacci = new Fibonacci();

        Thread threadMultiply = new Thread(fibonacci.multiply);

        Thread threadDivision = new Thread(fibonacci.divide);

        Thread threadResult = new Thread(fibonacci.result);

        threadMultiply.start();
        threadDivision.start();
    }
    //threadResult.start();
}