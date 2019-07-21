package java;

/*同步函数12
 * 
 * 
 * */
public class safeThread03 implements Runnable {
	private int ticket = 10;

	public void run() {
		//public synchronized void run() 如果直接加同步函数，那么同时只有一个线程A在运行，运行完成以后退出程序
		// 其他线程不会执行，那么如何解决呢，将要同步的代码封装成一个方法调用
		// TODO Auto-generated method stub
		while (true) {
			show();
		}

	}

	public synchronized void show() {

		if (ticket > 0) {
			try {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName().toString()
						+ "***" + ticket--);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		safeThread03 sf3 = new safeThread03();
		Thread A1 = new Thread(sf3);
		Thread A2 = new Thread(sf3);
		A1.start();
		A2.start();

	}

}
