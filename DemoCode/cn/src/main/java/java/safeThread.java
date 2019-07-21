package java;



public class safeThread implements Runnable {
	private int ticket=10;
	Object object = new Object();
	/*
	 * 线程安全问题 100张票共四个人买票，当剩余票数为一张时，A用户进入判断票数是否为0的判断，结果
	 * 判断为真，这时候具备了执行权，但是cpu在这一瞬间又去执行B用户的线程了，判断是否
	 * 大于0，为真，阻塞状态，这时候假如cpu切换到了C用户，判断是否大于0，同上，就会出 现票数为负数的情况
	 * 问题原因：
	 * 当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，另一个线程
	 * 参与进来执行，导致共享数据的错误
	 * 解决办法：
	 * 		对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中其他线程
	 * 		不可以参与执行
	 * Java对于多线程的安全问题提供了专业的解决方式，就是同步代码块
	 * 如何判断在哪里增加同步代码，就是看代码哪里使用到了共享数据
	 * 		在synchronized中同一时刻只能有一个线程在执行，我们把obj叫做锁，只有在锁
	 * 内的线程才能执行，在锁外的程序即使获取了cpu的执行权也进不去，因为没有获取锁
	 * synchronized可以简单的理解为火车上的卫生间的开关作用，用户进入之前首先会判断
	 * 是否有人，如果有人则wait，如果判断是没人，就进入，这样就保证了同一时刻只有一个
	 * 用户在上厕所，我们把这个故事叫做火车上的卫生间
	 * 同步的前提
	 * 			必须要有两个或者两个以上的线程才需要同步
	 * 			必须是多个线程使用同一个锁
	 * 			必须保证同步中只有一个线程在运行
	 * 好处：解决多线程的安全问题
	 * 弊端：多个线程都需要做判断，消耗了大量的资源
	 * @param args
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			synchronized (object) {//同步未成功
				if (ticket>0) {
					try {
						Thread.sleep(10);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println(Thread.currentThread().getName().toString()+"***"+ticket--);
				}
			}
		
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		safeThread sf = new safeThread();
		Thread t1 = new Thread(sf);
		Thread t2 = new Thread(sf);
		Thread t3 = new Thread(sf);
		Thread t4 = new Thread(sf);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
