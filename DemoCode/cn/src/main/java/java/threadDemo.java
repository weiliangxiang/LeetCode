package java;

/*1.发现该程序每次执行的结果都不一样，为什么呢
 *  明确一点，多个线程都获取cpu的执行权，cpu执行到谁，谁就在执行，执行权在cpu
 * 	明确一点，在某一时刻，只有一个程序在运行（多核除外），cpu在做着快速切换，以达到
 * 	看上去同时运行的效果，我们可以形象的把多线程的运行行为理解为在互相抢夺资源
 * 	这就是多线程的一个特点，随机性
 * 2.为什么要覆盖run方法呢
 * 	目的：将自定义的代码存储在run方法中，让线程运行
 * 	Thread类用于描述线程，该类就定义了一个功能，用于存储线程运行的代码，该存储功能
 * 	就是run方法。也就是thread类中的run方法是用于存储线程要运行的代码，为什么不存
 * 	存放在main方法中，那就是主线程了，所以
 * 	Thread t= new Thread();
	t.run()
	如果这样写，thread不知道运行什么run方法
 * 	
 * 3.调用线程的start方法
 * 该方法有两个作用，一个是启动线程，一个是调用run方法
 * 如果调用run方法，则会执行完成子方法才会接着执行main防范，如果调用start方法，
 * 在继续执行main方法的同时，开辟新的路径执行子方法
 * 
 * 
 * */
public class threadDemo extends Thread {

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("demo run" + i);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadDemo demo = new threadDemo();
		//demo.start();//开启线程并执行线程的run方法
		demo.run();//仅仅是对象调用方法，而线程创建了，并没有运行
		for (int i = 0; i < 10; i++) {
			System.out.println("main run" + i);
		}
	}
	
}
