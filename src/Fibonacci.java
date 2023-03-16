import java.util.ArrayList;

public class Fibonacci {
    Object lock = new Object();
    ArrayList<Double> numbers = new ArrayList<>();


    private void addingArray() {

        numbers.add(0.0);
        numbers.add(1.0);
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(5.0);
        numbers.add(8.0);
        numbers.add(13.0);
        numbers.add(21.0);
        numbers.add(34.0);

    }

    Runnable divide = () -> {
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        addingArray();

        for (int i = 0; i < 9; i = i + 2) {
            double sum = numbers.get(i) + numbers.get(i + 1);
            double difference = sum / 2;

            System.out.println("результат деления - " +difference);
        }
    };

    Runnable multiply = () -> {
        synchronized (lock){
                lock.notify();
        }
        addingArray();

        for (int i = 0; i < 9; i = i + 2) {
            double composition = numbers.get(i) * numbers.get(i + 1);

            System.out.println("результат умножения - " + composition);

        }
    };

    Runnable result = () ->{
      multiply.run();
      divide.run();
    };

}
