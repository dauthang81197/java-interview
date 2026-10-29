package practice;

// Problem is ATOMICITY (nguyen tu) count++ khong an toan
public class RaceConditionDemo {
//    static int count = 0;   // Bước 1 chạy
    static volatile int count = 0;  // Bước 2 thay với volatile nhưng vẫn ko đúng
    // Bước 3: thêm 'synchronized' vào method dưới -> ĐÚNG
    static synchronized void increment() {
        count++;  // thực chất 3 bước: đọc -> cộng 1 -> ghi
    }
    public static void main(String[] args) throws InterruptedException{
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Kết quả: " + count + " (mong đợi 200000)");
    }
}
