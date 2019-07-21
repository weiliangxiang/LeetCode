package java;
/*步骤：
 * 1.定义类实现runnable接口
 * 2.覆盖runnable接口的run方法
 * 	将线程要运行的代码存放在run方法中
 * 3.通过thread类建立对象
 * 4.将runnable接口的子类对象作为实际参数传递给thread类的构造函数
 * 		为什么要将runnable接口的子类对象传递给thread构造函数
 * 		因为自定义的run方法的所属对象是runnable接口的子类对象，所以要让线程去执行指定对象的
 * 		run方法，就必须要明确该run方法所属的对象
 * 5.调用thread的start方法开启线程并调用runnable接口子类的run方法
 * thread和runnable实现的方式有什么区别呢：
 *    实现方式好处在于避免了单继承的局限性，在定义线程时，建议使用实现方式
 *    继承thread线程代码的位置存放在Thread子类run方法中，实现runnable存放在接口的子类的run方法中
 * 
 * */
 public class runableDemo implements Runnable{
	 private int ticket=100;
	 public void run() {
			while (true) {
				if (ticket>0) {
					System.out.println(Thread.currentThread().getName().toString()+ticket--);
				}
			}
			
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runableDemo rd = new runableDemo();
		Thread t1 = new Thread(rd);
		Thread t2 = new Thread(rd);
		t1.start();
		t2.start();
	}

	

}
