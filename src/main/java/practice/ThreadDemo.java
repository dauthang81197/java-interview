package practice;

public class ThreadDemo {
       // Volatile buộc mọi thread đọc/ghi đọc thẳng vào bộ nhớ chính nên luôn thấy giá trị mới nhâst
        static volatile boolean running = true;
        public static void main(String[] args) throws InterruptedException {
            Thread worker = new Thread(() -> {
                long count = 0;
                while (running) {
                    count++;
                }
                System.out.println("Worker đã dừng, count = " + count);
            });
            worker.start();

            Thread.sleep(1000);
            running = false;             // main thread tắt cờ
            System.out.println("Main đã set running = false");
            worker.join(3000);
            System.out.println(worker.isAlive() ? "❌ Worker VẪN CHẠY (không thấy giá trị mới)" : "✅ Worker đã dừng");
            System.exit(0);
        }
}
