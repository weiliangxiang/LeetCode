package day11;
/*
* 创建两个线程和主线程交替运行
*
*
* */

public class BThreadTest {
    public static void main(String[] args){
        Test t =new Test("one");
        Test t1 =new Test("two");
        t.start();t1.start();
        for (int i = 0; i <60 ; i++) {
            System.out.println("main"+i);
        }


    }
}
class Test extends Thread{
    private String name;
    public Test(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i <60 ; i++) {
            System.out.println(name+i+"----");
        }
    }
}
