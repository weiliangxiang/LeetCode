package demo20171203;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class task implements Callable<Integer>{
	private int begin;
	private int end;
	
	

	public int getBegin() {
		return begin;
	}


	public void setBegin(int begin) {
		this.begin = begin;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public task(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}


	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = begin; i < end; i++) {
			sum+=i;
		}
		return sum;
	}
	
}
public class TestCall {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		//ExecutorService executorService=Executors.newCachedThreadPool();
		//调用task方法
		task task01=new task(0, 50);
		//将task线程进行包装，包装成futuretask以便于在多线程运行时获取sum值
		FutureTask<Integer> futureTask01=new FutureTask<Integer>(task01);
		executorService.submit(futureTask01);
		
		task task02=new task(50, 100);
		FutureTask<Integer> futureTask02=new FutureTask<Integer>(task02);
		executorService.submit(futureTask02);
		
//		task task03=new task(100, 150);
//		FutureTask<Integer> futureTask03=new FutureTask<Integer>(task03);
//		executorService.submit(futureTask03);
		try {
			try {
				System.out.println(futureTask01.get(2, TimeUnit.SECONDS)+futureTask02.get());
			} catch (TimeoutException e) {
				
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
	}
	

}
