package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void NewThreadDemo() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            Thread t = new Thread(() ->
                    System.out.println("Task " + taskId + " chạy bởi " + Thread.currentThread().getName()));
            t.start();
            t.join();
        }
        System.out.println("Thời gian: " + (System.currentTimeMillis() - start) + " ms");
        // When using new Thread(), each thread handles only one task,
        // So with many tasks, too many thread created, which consumes a lot of memory
        // Vấn đề: 10.000 request -> 10.000 thread -> tốn RAM (mỗi thread ~1MB stack), dễ OutOfMemoryError
    }

    public static void ThreadPoolDemo() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);   // 3 "công nhân" cố định

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            pool.submit(() -> {                                   // giao việc, task chờ trong hàng đợi
                System.out.println("Task " + taskId + " chạy bởi " + Thread.currentThread().getName());
                sleep(500);
            });
        }

        pool.shutdown();                                          // không nhận task mới, chạy nốt task cũ
        pool.awaitTermination(1, TimeUnit.MINUTES);               // đợi tất cả xong
        System.out.println("Xong hết!");
    }
    static void sleep(long ms) { try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } }

    public static void main(String[] args) throws InterruptedException {
        NewThreadDemo();
    }
}
