package com.zxc.base.study.basicknowledge.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lockInterruptibly()允许在等待时由其他线程的Thread.interrupt()方法来中断等待线程而直接返回，这时是不用获取锁的，
 * 而会抛出一个InterruptException。而ReentrantLock.lock()方法则不允许Thread.interrupt()中断，
 * 即使检测到了Thread.interruptted一样会继续尝试获取锁，失败则继续休眠。
 * 只是在最后获取锁成功之后在把当前线程置为interrupted状态。
 *
 * @author zxc
 * @date 2020/10/13 14:55
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunIt());
        Thread t2 = new Thread(new RunIt());

        t1.start();
        System.out.println("````````1``````````");
        t2.start();
        System.out.println("````````2``````````");
        t1.interrupt();
        System.out.println("````````3``````````");
    }
}
class RunIt implements Runnable{

    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            runJob();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" Interrrupted from runJob.");
        }
    }

    private void runJob() throws InterruptedException{
//        lock.lockInterruptibly();
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" 到此一游....");
        try{
            System.out.println(Thread.currentThread().getName() + " running");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " finished");

        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }finally{
            lock.unlock();
        }
    }
}