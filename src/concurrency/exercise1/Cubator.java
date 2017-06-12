package concurrency.exercise1;

/**
 * Created by davlet on 6/10/17.
 */
public class Cubator implements Runnable {
    int[] exp;

    public Cubator(int[] exp) {
        this.exp = exp;
    }

    @Override
    public void run() {
        System.out.println("Cubator thread");
        calculate(this.exp);
    }

    public int calculate(int[] expression) {
        return (int) Math.pow(expression[0], 3);
    }
}
