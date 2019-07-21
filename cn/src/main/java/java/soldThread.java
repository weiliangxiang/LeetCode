package java;
/*需求：买票的小程序
 * 多个窗口可同时卖票
 * 
 * 
 * */
public class soldThread extends Thread {
	//int  ticket=20;如果是这样的话，线程1有100张票，线程2也有一百张票，如何解决这个问题呢
		private  static int ticket=20;

	public void run() {
		// TODO Auto-generated method stub
	
		while (true) {
			if (ticket>0) {
				
				System.out.println(Thread.currentThread().getName().toString()+"正在售票"+ticket--);
			}
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			soldThread ST = new soldThread();
			ST.start();
		}

	}

}
