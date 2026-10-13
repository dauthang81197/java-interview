package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.senior.t03_concurrency.Bai40SrBank.Account;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class Bai40SrBankTest {

    @Test
    void basicTransfer() {
        Bai40SrBank bank = new Bai40SrBank();
        Account a = new Account(1, 100), b = new Account(2, 50);
        assertTrue(bank.transfer(a, b, 30));
        assertEquals(70, bank.balanceOf(a));
        assertEquals(80, bank.balanceOf(b));
    }

    @Test
    void insufficientFunds() {
        Bai40SrBank bank = new Bai40SrBank();
        Account a = new Account(1, 10), b = new Account(2, 0);
        assertFalse(bank.transfer(a, b, 11));
        assertEquals(10, bank.balanceOf(a));
        assertEquals(0, bank.balanceOf(b));
    }

    @Test
    void selfTransferAndInvalidAmount() {
        Bai40SrBank bank = new Bai40SrBank();
        Account a = new Account(1, 10);
        assertTrue(bank.transfer(a, a, 5));
        assertEquals(10, bank.balanceOf(a));
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(a, new Account(2, 0), 0));
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(a, new Account(2, 0), -5));
    }

    @Test
    void crossTransfersDoNotDeadlockAndConserveMoney() {
        assertTimeoutPreemptively(Duration.ofSeconds(20), () -> {
            Bai40SrBank bank = new Bai40SrBank();
            Account a = new Account(1, 1_000_000), b = new Account(2, 1_000_000);
            int n = 200_000;
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < n; i++) bank.transfer(a, b, 1);
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < n; i++) bank.transfer(b, a, 1);
            });
            t1.setDaemon(true);
            t2.setDaemon(true);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            assertEquals(2_000_000, bank.balanceOf(a) + bank.balanceOf(b));
            assertEquals(1_000_000, bank.balanceOf(a));
        });
    }

    @Test
    void manyAccountsRandomTransfers() {
        assertTimeoutPreemptively(Duration.ofSeconds(30), () -> {
            Bai40SrBank bank = new Bai40SrBank();
            Account[] acc = new Account[5];
            for (int i = 0; i < acc.length; i++) acc[i] = new Account(i, 10_000);
            Thread[] ts = new Thread[8];
            for (int t = 0; t < ts.length; t++) {
                final int seed = t;
                ts[t] = new Thread(() -> {
                    java.util.Random r = new java.util.Random(seed);
                    for (int i = 0; i < 50_000; i++) {
                        bank.transfer(acc[r.nextInt(5)], acc[r.nextInt(5)], 1 + r.nextInt(50));
                    }
                });
                ts[t].setDaemon(true);
                ts[t].start();
            }
            for (Thread t : ts) t.join();
            long total = 0;
            for (Account a : acc) {
                long bal = bank.balanceOf(a);
                assertTrue(bal >= 0);
                total += bal;
            }
            assertEquals(50_000, total);
        });
    }
}
