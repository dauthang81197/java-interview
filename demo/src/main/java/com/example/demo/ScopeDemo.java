package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component                       // không ghi gì = singleton
class SingletonBean {

}

@Service
class Order1Service {
    private int count = 0;

    public int placeOrder() {
        count++;
        return count;
    }
}

@Component
@Scope("prototype")
 class PrototypeBean { }

@SpringBootApplication
class ScopeDemo implements CommandLineRunner {
    @Autowired
    ApplicationContext ctx;
    private final Order1Service orderService;

    ScopeDemo(Order1Service orderService) {
        this.orderService = orderService;
    }


    public static void main(String[] args) { SpringApplication.run(ScopeDemo.class, args); }

    @Override
    public void run(String... args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0; i<1000; i++) {
            pool.submit(orderService::placeOrder);
        }
        pool.shutdown();

        pool.awaitTermination(10, TimeUnit.SECONDS);  // đợi làm xong hết
        // The reason: Because Scope bean of service is Singleton, so multiple thread will be execute the same method concurrently
        System.out.println("Kết quả: " + orderService.placeOrder());
     }

}
