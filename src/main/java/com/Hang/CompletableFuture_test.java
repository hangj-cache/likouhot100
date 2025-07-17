package com.Hang;

import java.util.Random;
import java.util.concurrent.*;


public class CompletableFuture_test {

    // main线程是独立的，不属于这里面
    private static final ExecutorService executor = Executors.newFixedThreadPool(5, r -> new Thread(r, "OrderProcessint" + r.hashCode()));

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("主线程用户点击下单按钮");

        long orderId = 12345L;
        String userEmail = "hangj@163.com";

        // 创建订单
        System.out.println("主线程：正在创建订单……");
        TimeUnit.SECONDS.sleep(2); // 模拟创建订单的耗时，异步操作
        System.out.println("主线程，订单ID："+orderId+"，创建成功");

        // 异步处理库存扣减和邮件发送
        // 使用completableFuture.runAsync将任务提交到线程池处理
        CompletableFuture<Void> deductStockFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "：正在执行异步任务");  // Thread.currentThread().getName() + ":正在异步扣减库存"这行代码只是在当前正在执行扣减库存任务的那个线程中打印一条日志信息
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2) + 1); // 模拟耗时 1 - 2秒
                System.out.println(Thread.currentThread().getName() + "：扣减库存成功");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // 表示加入发生异常的时候中断当前的线程
                System.out.println(Thread.currentThread().getName() + "：扣减库存操作被中断");
            }
        }, executor);// 指定线程池

        CompletableFuture<Void> sendEmailFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ":当前线程正在异步发送邮件" + userEmail + "...");
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2) + 2); // 模拟发送邮件耗时2-3秒
                System.out.println(Thread.currentThread().getName() + ":发送邮件成功");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + ":发送邮件操作被中断");
            }
        }, executor);

        // 当所有异步操作都完成后执行后续操作  CompletableFuture.allOf(deductStockFuture, sendEmailFuture);就是等deductStockFuture和sendEmailFuture异步操作完成后执行异步操作allTasks（这是这个方法返回的异步方法）
        // allTasks异步操作通过thenRunAsync定义异步任务的内容
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(deductStockFuture, sendEmailFuture);
        allTasks.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ":所有订单后续异步处理（库存和邮寄）都已完成，可以更新订单状态为已完成");
        },executor);

        // 主线程继续做，不用等待上面CompletableFuture的处理任务，因为是基于多线程处理的
        System.out.println("主线程：" + orderId +"已提交，您可以继续浏览其他商品或订单状态。");
        System.out.println("主线程做其他不相关的操作...");
        // 模拟主线程的其他操作
        TimeUnit.SECONDS.sleep(5);

        System.out.println("主线程：等待所有异步处理完成，以确保程序退出前任务都已执行。");
        allTasks.get();  // 因为allTasks就是CompletableFuture<Void> allTasks = CompletableFuture.allOf(deductStockFuture, sendEmailFuture);即使剩下的所有异步任务

        // 关闭自定义的线程池
        executor.shutdown();
        System.out.println("主线程：任务执行完毕");

    }
}
