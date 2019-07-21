package day11;
/*
* 线程运行过程：
*                       临时状态阻塞，具备运行资格，但是没有执行权
*                                         ⬆
*                                          \
*                                           \
*                                            \ 线程冻结结束以后并不能直接运行，会处于临时
*       start()              sleep(time)      \状态，或得执行权后处于运行状态
 * 被创建----------------->运行------------->冻结（放弃执行资格）
*           |                  wait()
*           |stop()            notify()
*           |run()方法结束
*           ⬇
*          消亡
*
*new Thread类后线程就会被创建，创建完以后通过start()方法就行运行，运行完以后线程有几种状态，
* 第一种是冻结，就是线程运行着突然停止，cpu说停停停一会运行，我先去运行其他的，保留线程现在的状态，
* 冻结分为sleep(time)和wait(time)，sleep结束的时间就是sleep time的时间到，wait结束的是时间
* 就是通过notifiy即唤醒机制
* 第二种状态就是消亡，也就是Thread.stop()方法或者run方法结束
* 第三种是阻塞状态：同时开启四个线程，同一时间只有一个线程在运行，其他三个线程就属于阻塞状态，我们
* 叫做具备运行资格，但是没有执行权
*
*
* */
public class CThreadStatus {
    public static void main(String[] args){
        //获取线程名称
        getThreadName name1 =new getThreadName();
        getThreadName name2 =new getThreadName();
        name1.start();name2.start();
        //自定义线程名称
        setThreadName setname =new setThreadName("rename");
        setname.start();

    }
}
class getThreadName extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <1; i++) {
            //线程都有自己默认的编号，默认Thread-0的方式
            System.out.println(this.getName()+"第"+i+"运行");
        }
    }
}
class setThreadName extends Thread{
    //线程名称在初始化的时候就已经加载了，所以我们需要复写构造方法传入我们要set的线程名称
    public setThreadName(String name) {
        super(name);
    }

    @Override
    public void run() {
        //tip:局部变量在每一个线程都有独立的内存空间，线程0和线程1同时加载进来以后，加载的不是同一个i
        for (int i = 0; i <10 ; i++) {
            System.out.println(this.getName()+"第"+i+"运行");
        }
    }
}
