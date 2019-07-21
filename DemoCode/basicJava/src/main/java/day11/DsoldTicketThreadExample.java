package day11;
/*
* 需求：实现一个简单的卖票程序
* 多线程好实现，但是如何确定内存
*
*
* */
public class DsoldTicketThreadExample {
    public static void main(String[] args){
        ticket t =new ticket();
        ticket t2 =new ticket();
        ticket t3 =new ticket();
        ticket t4 =new ticket();
        t.start();t2.start();t3.start();t4.start();
    }
}
//1.首先实现卖票功能，复写run方法
class ticket extends Thread{
    private static int ticknum=100;//多个线程共享100张票，所以需要加static
    @Override
    public void run() {
        while (true){
            if (ticknum>0){
                System.out.println(this.getName()+"剩余"+ticknum--+"张票");
            }
        }
    }
}
