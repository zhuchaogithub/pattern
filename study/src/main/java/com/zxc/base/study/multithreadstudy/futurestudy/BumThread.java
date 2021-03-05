package com.zxc.base.study.multithreadstudy.futurestudy;

/**
 * @author zxc
 * @date 2021/2/24 17:06
 */
public class BumThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000*3);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
