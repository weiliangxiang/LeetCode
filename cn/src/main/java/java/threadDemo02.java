package java;

public class threadDemo02 extends Thread {
//练习：创建两个线程与主线程交替运行
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("子线程"+Thread.currentThread().getName().toString());
		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadDemo02 t2 = new threadDemo02();
		threadDemo02 t3 = new threadDemo02();
		t2.start();
		t3.start();
		//t2.run();
		//t3.run();//顺序执行
		/*如果使用run，编译没有问题，但是出现一个问题，就是如果run方法执行时间过长，
		 * 比如run执行6万次，那么如果t2没有运行完成，那么t3也就不会运行，如果使用两个
		 * 独立的控制单元，那么就可以实现同时运行，提高工作效率 
		 * */
		for(int i=0;i<10;i++){
			System.out.println("这里是main方法");
		}

	}

}
