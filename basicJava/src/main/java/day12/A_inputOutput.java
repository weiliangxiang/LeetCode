package day12;

public class A_inputOutput {
    Res r = new Res();
    input in = new input(r);
    output out = new output(r);
    Thread t1 =new Thread(in);
    Thread t2 =new Thread(out);

}
//定义一个共享资源姓名和性别
class Res {
    String name;
    String sex;
}

class input implements Runnable {
    private Res r;
    input(Res r) {
        this.r = r;
    }

    public void run() {
        int x = 0;
        while (true) {
            if (x == 0) {
                r.name = "魏良响";
                r.sex = "男";
            } else {
                r.name = "xiechunli";
                r.sex = "Mrs";
            }
            x = (x + 1) % 2;
        }
    }
}

class output implements Runnable {
    private Res r;
    output(Res r) {
        this.r = r;
    }
    public void run() {
        while (true) {
            System.out.println(r.name + "......" + r.sex);
        }
    }
}