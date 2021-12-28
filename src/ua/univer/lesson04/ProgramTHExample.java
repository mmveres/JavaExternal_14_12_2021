package ua.univer.lesson04;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread " +Thread.currentThread().getName()+" start");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread " +Thread.currentThread().getName()+" end");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable "+Thread.currentThread().getName()+" start");
        System.out.println("MyRunnable "+Thread.currentThread().getName()+" end");
    }
}
public class ProgramTHExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main " +Thread.currentThread().getName()+" start");

        Thread th1 = new MyThread();
        th1.start();
        Thread th2 = new Thread(new MyRunnable());
        th2.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("AnnonimThread " +Thread.currentThread().getName()+" start");
                System.out.println("AnnonimThread " +Thread.currentThread().getName()+" end");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("AnnonimRunnable " +Thread.currentThread().getName()+" start");
                System.out.println("AnnonimRunnable " +Thread.currentThread().getName()+" end");
            }
        }).start();

        Thread th3 =new  Thread(() -> {
                System.out.println("AnnonimRunnable " +Thread.currentThread().getName()+" start");
                while(!Thread.interrupted()){
                    System.out.println(LocalDateTime.now());
                }
                System.out.println("AnnonimRunnable " +Thread.currentThread().getName()+" end");
        });
        th3.start();

        th1.join();
        th3.interrupt();
        System.out.println("main " +Thread.currentThread().getName()+" end");

        Executor thPool = Executors.newSingleThreadExecutor();
        thPool.execute(new MyRunnable());
        thPool.execute(
                () -> {
            System.out.println("ThPool " +Thread.currentThread().getName()+" start");
            System.out.println("ThPool " +Thread.currentThread().getName()+" end");
        });

       // ArrayBlockingQueue
       // Hashtable
       // Map<Integer, Integer> map = new HashMap<>();
       // Map<Integer, Integer> syncmap =Collections.synchronizedMap(map);
      //  ConcurrentHashMap
    }
}
