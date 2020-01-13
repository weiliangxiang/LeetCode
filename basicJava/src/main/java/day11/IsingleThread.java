package day11;
/*
* 单例设计模式
* 饿汉式
*
*请写出一个延迟加载的单例设计模式！！！！！！重要重要重要
* 懒汉式：特点实例的延迟加载，延时加载可能会出现安全问题，如何解决？通过同步函数解决，但是同步函数
* 有性能会下降，通过双重判断提高性能
*
* */
public class IsingleThread {

}
class Single{
    private static Single single=null;
    private Single(){}
    public static synchronized Single getInstance(){
        if (single==null){
            //  -----A
            //  -----B,如果不佳synchronized，可能会出现线程安全问题，new不同的Single
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
        }
