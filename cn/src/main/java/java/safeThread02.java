package java;
/*同步函数
 * 
 * 
 * */
public class safeThread02 implements Runnable {
	private int ticket=10;

	public synchronized void run() {
		//如果直接加同步函数，那么同时只有一个线程A在运行，运行完成以后退出程序
		//其他线程不会执行，那么如何解决呢，将要同步的代码封装成一个方法调用
		//见safeThread03
		// TODO Auto-generated method stub
		while (true) {
			if (ticket>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName().toString()+"***"+ticket--);
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		safeThread02 sf2=new safeThread02();
		Thread A1=new Thread(sf2);
		Thread A2=new Thread(sf2);
		A1.start();A2.start();
		

	}

}
