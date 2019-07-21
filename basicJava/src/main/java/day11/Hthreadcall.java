package day11;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/*
* 1.先定义一个Callable的实现类，并重写call()方法
* 2.创建Callable实现类的对象，并作为参数传给FutureTask对象
* 3.FutureTask作为参数传给Thread类对象
* 4.并执行start()方法
*
*
* */
public class Hthreadcall {
    public static void main(String[] args){
        Integer sum;
        //创建Callable实现类的对象
        callDemo c =new callDemo();
        //将Callable对象作为参数传递给FutureTask对象
        FutureTask<Integer> result =new FutureTask<Integer>(c);
        //将FutureTask对象作为参数传递给Thread类对象
        Thread thread =new Thread(result);
        Thread thread1 =new Thread(result);
        //执行start方法
        thread.start();thread1.start();
        try {
            sum=result.get();
            System.out.print(Thread.currentThread().getName()+"sum= "+sum);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
class callDemo implements Callable<Integer> {
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i <100 ; i++) {
            sum=sum+i;
        }
        return sum;
    }
}
