package java8.practice;

/**
 * Created by davlet on 6/16/17.
 */
@FunctionalInterface
public interface ThreadStartInterface {
    void startThread(Runnable runnable);
}
