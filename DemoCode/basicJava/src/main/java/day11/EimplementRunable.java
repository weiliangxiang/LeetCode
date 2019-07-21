package day11;
/*
* 创建线程的第二种方式
* 步骤
* 1.定义实现runnable接口
* 2.覆盖run方法，将线程要运行的代码存放在run方法中
* 3.通过thread类建立线程对象
* 4.将runnbale接口的子类对象作为实际参数传递给Thread类的构造方法
* 为什么要将runnable接口的子类对象传递给Thread的构造方法，因为自定义的run方法所属的对象是
* runnable接口的子类对象，所以要让线程去执行指定对象的run方法，就必须明确该run方法所属对象
* 5.调用Thread类的start方法并调用runnable接口子类的run方法
* 多线程实现和implement有什么区别：
*1.implement方式的好处：避免了但继承的好处，在定义线程的时候，建议使用实现的方式
*2.线程代码存放的位置，extend Thread线程代码存放在Thread子类的run方法中
* implement Thread线程代码存放在接口的子类的run方法中，最为常用
*
* */
public class EimplementRunable {
    public static void  main(String[] args){
        ticketimp ti = new ticketimp();
        Thread t1 =new Thread(ti);
        Thread t2 =new Thread(ti);
        Thread t3 =new Thread(ti);
        Thread t4 =new Thread(ti);
        t1.start();t2.start();t3.start();t4.start();

    }
}
class ticketimp implements Runnable{
    private int ticket=100;
    public void run() {
        while(true){
            if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+" sale-----"+ticket--);
            }
        }

    }
}
