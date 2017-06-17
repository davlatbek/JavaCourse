package concurrency.exercise1;

/**
 * Created by davlet on 6/10/17.
 */
public class Semaphore {
    private Integer[] x;
    private Integer[] y;
    private Integer[] z;
    public Integer resultX = 0;
    public Integer resultY = 0;
    public Integer resultZ = 0;

    public Semaphore(Integer[] x, Integer[] y, Integer[] z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void save(Integer result) {
        Thread currentThread = Thread.currentThread();
        Class objectClass = Thread.currentThread().getClass();
        synchronized (objectClass){
            if (currentThread instanceof Singulator){
                this.resultX += result;
                System.out.println(resultX);
            }
            if (currentThread instanceof Quadrator){
                this.resultY += result;
                System.out.println(resultY);
            }
            if (currentThread instanceof Cubator){
                this.resultZ += result;
                System.out.println(resultZ);
            }
        }
    }
}
