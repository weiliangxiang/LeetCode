package day11;
/*
* 通过分析发现，打印出0 -1 -2
* 多线程运行出现了安全问题
* 问题的原因：
*   当执行多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有
* 执行完，另一个线程也参与进来，导致共享数据的错误
* 解决办法：
*   对多条操作共享数据的语句，只能让一个线程执行完，在执行过程中，其他线程不可以参与执行
* java对于多线程的安全问题提供了专业de解决方式，就是代码块
* synchronized(对象)
* {
*       需要同步的代码块
* }
*
* 对象如同锁，持有锁的线程可以在同步中进行，没有锁的线程即使获取cpu的执行权，也不进去，因为没有获取锁
*好处：解决了线程安全的问题
* 弊端：多线程需要判断锁，较为消耗资源
*
* */
public class FthreadSafe {
    public static void main(String[] args){
        ticketSold ticketSold =new ticketSold();
        Thread thread = new Thread(ticketSold);
        Thread thread2 = new Thread(ticketSold);
        thread.start();thread2.start();
    }

}
class ticketSold implements Runnable{
    private int ticket_num=100;
    public void run() {
        while (true){
            /*当四个线程同时运行到这时，就会出现操作一个变量ticket_num，如当线程0操作ticket——num=1的时候
            代码判断满足if条件，这时候假如线程处于cpu切换状态，线程停止，切换到线程1操作tickt——number，这时候剩余数量为1
            还没有执行--的操作，所以执行代码逻辑仍然符合条件，假如四个线程同时卡在这，就会出现剩余1张票，四个线程都满足条件，。。。。
            结果就是sale票数为负数的情况，解决防范就是添加同步代码块*/
            synchronized (new Object()){
                if (ticket_num>0){
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){
                        System.out.println("线程sleep失败");
                    }
                    System.out.println(Thread.currentThread().getName()+"sale--"+ticket_num--);
                }
            }

        }
    }
}
