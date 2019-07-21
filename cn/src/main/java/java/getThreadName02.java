package java;
//练习：自定义线程名称(建议使用currentThread)
/*
 * 
 * 
 * */
public class getThreadName02 extends Thread {
	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			System.out.println(threadDemo02.currentThread().getName().toString()+i);	
		}
	}
	
	public  getThreadName02(String name){
		super(name);//直接调用父类方法
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getThreadName02 getname01= new getThreadName02("wlx");
		getThreadName02 getName02= new getThreadName02("zxd");
		getname01.start();
		getName02.start();
	}

}
