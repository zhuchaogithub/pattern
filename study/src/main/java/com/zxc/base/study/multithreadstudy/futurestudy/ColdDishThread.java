package com.zxc.base.study.multithreadstudy.futurestudy;

/**
 * @author zxc
 * @date 2021/2/24 17:13
 */
public class ColdDishThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜已准备");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
