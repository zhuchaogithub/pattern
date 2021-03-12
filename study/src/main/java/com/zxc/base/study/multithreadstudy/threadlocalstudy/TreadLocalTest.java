package com.zxc.base.study.multithreadstudy.threadlocalstudy;

/**
 * @author zxc
 * @date 2021/3/11 10:45
 */
public class TreadLocalTest {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        public Integer initialValue() {
            return 0;
        }
    };

    public int getSeqNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        TreadLocalTest treadLocalTest = new TreadLocalTest();
        TestClient testClient = new TestClient(treadLocalTest);
        TestClient testClient1 = new TestClient(treadLocalTest);
        TestClient testClient2 = new TestClient(treadLocalTest);
        testClient.start();
        testClient1.start();
        testClient2.start();
    }

    private static class TestClient extends Thread{
        private TreadLocalTest sn;

        public TestClient(TreadLocalTest sn){
            this.sn = sn;
        }

        public void run(){
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] : "
                        + sn.getSeqNum() );
            }
        }

    }
}
