package day11;
/*
* 需求：银行有一个金库，有两个线程分别存300元，每次存100元，存三次
* 问题：是否有安全问题，如何解决
*如何找到问题：
* 1.明确那些代码是多线程运行代码
* 2.明确共享数据
* 3.明确多线程运行代码中那些是操作共享线程数据
* */
public class GthreadRsymain {
    public static void main(String[] args){
        cus cus =new cus();
        Thread thread =new Thread(cus);
        Thread thread1=new Thread(cus);
        thread.start();thread1.start();
    }
}
//描述一个银行类，并提供累计存入的方法
class Bank{
    private int sum;
    public void  add(int n){
        sum = sum+n;
        System.out.println("sum="+sum);
    }
}
//定义储户，并提供存钱的方法给多线程
class cus implements Runnable{
    private Bank bank=new Bank();
    public void run() {
        try {
            Thread.sleep(20);

        }catch (Exception e){
            System.out.print("线程睡眠失败");
        }
        for (int i = 0; i <3 ; i++) {
            bank.add(100);
        }
    }
}
