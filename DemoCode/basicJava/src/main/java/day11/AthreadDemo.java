package day11;
/*
* 通过对api的查找，java已经提供了对线程这类事物的描述，就是Thread类，创建线程的第一种方式：继承Thread类
* 1.定义类继承Thread
* 2复写Thread类中的run方法，目的是将自定义的代码存储在run防范中，让线程运行
* 3调用线程的start方法
* 发现运行结果每次都不同，因为多个线程都在获取cpu的执行权，cpu执行到谁，谁就运行，明确一点
* 在某个时刻，只有一个程序在运行（多核除外），cpu在快速的切换，以达到同时运行的效果
* 我们可以形象吧多线程的运行行为在互相抢夺cpu的执行权
* 这就是多线程的特性，随机性，谁抢到谁执行，至于执行多长时间，cpu说了算
* 覆盖run方法的原因：
* Thread类用于描述线程
* 该类就定义了一个功能，用于存储线程要运行的代码，该存储功能就是run方法
* 也就是说Thread类中的run方法，用于存储线程要运行的代码
*
*
* 问题：
* 为什下面的代码如果把helloWord放前面，线程放后面，每次执行的时候都是一样的，先h后demo，
* 颠倒一下顺序就会出现cpu抢占的问题呢
*
*
* */
public class AthreadDemo{
    public static void main(String[] args){
        Demo d =new Demo();Demo d2 =new Demo();//创建线程
        d.start();d2.start();//开始执行线程
        //d.run();//仅仅对象调用方法而线程创建了并没有运行，也就是先运行run再执行hello
        for (int i = 0; i < 100; i++) {
                System.out.println("Hello World--"+i);
        }
    }

}
class Demo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <60 ; i++) {
            System.out.println(Thread.currentThread().getName()+"demo run--"+i);
        }
    }
}
