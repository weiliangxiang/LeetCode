package java;
//练习：获取线程名称
//练习：如何自定义线程名称
public class getThreadName extends Thread{
	
/*线程都有自己的默认名称，Thread-编号
 * currentThread：获取当前线程对象
 * getName：获取线程名称
 * setName：设置线程名称
 * 
 * 
 * */
	public void run() {
		// TODO Auto-generated method stub
		String string = Thread.currentThread().getName().toString();
		System.out.println(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++){
			getThreadName getname= new getThreadName();
			getname.start();
		}

	}

}
