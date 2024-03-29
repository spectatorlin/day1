package month;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 邹松林
 * @version 1.0
 * @Title: ThreadPollDemo
 * @Description: TODO
 * @date 2023/9/25 21:18
 */
public class ThreadPollDemo {
    public static void main(String[] args) {

        ExecutorService executorService0 = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

    }
}
