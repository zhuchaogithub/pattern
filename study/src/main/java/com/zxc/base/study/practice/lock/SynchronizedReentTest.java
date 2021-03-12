package com.zxc.base.study.practice.lock;

/**
 * @author zxc
 * @date 2021/3/10 16:07
 */
public class SynchronizedReentTest implements Runnable {

    static SynchronizedReentTest instance=new SynchronizedReentTest();
    static int i=0;
    static int j=0;
    @Override
    public void run() {
        for(int j=0;j<100;j++){
            //this,当前实例对象锁
            synchronized(this){
                System.out.println("i加入锁="+ i);
                i++;
                System.out.println(i);
                increase();//synchronized的可重入性
            }
        }
    }
    public synchronized void increase(){
        System.out.println("j加入锁"+j);
        j++;

    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
//        Thread t2=new Thread(instance);
        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(i);
    }
}
