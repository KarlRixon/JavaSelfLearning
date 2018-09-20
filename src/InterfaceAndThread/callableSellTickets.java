package InterfaceAndThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class callableSellTickets {
	public static int ticket = 50;
	// Callable与Runnable相比只是多了返回值，但Runnable使用更广泛
	public static class MyThread implements Callable<String>{
		private String name;
		private int t = 0;
		public MyThread(String name) {
			this.name = name;
		}
		@Override
		public String call() throws Exception{
			for(; ticket > 0; ) {
				if(ticket > 0) {
					System.out.println("买票，ticket = "+ticket--);
					this.t++;
				}
			}
			return this.name+"买了"+this.t+"张票";
		}
	}
	public static void main(String[] args) throws Exception{
		MyThread mt1 = new MyThread("张三");
		MyThread mt2 = new MyThread("李四");
		FutureTask<String> task1 = new FutureTask<String>(mt1);
		FutureTask<String> task2 = new FutureTask<String>(mt2);
		// FutureTask是Runnable接口子类，可以使用Thread类的构造来接受Task对象
		new Thread(task1).start();
		new Thread(task2).start();
		// 多线程执行完毕以后可以取得内容，依靠FutureTask的父接口Future中的get
		System.out.println("A线程返回结果："+task1.get());
		System.out.println("B线程返回结果："+task2.get());
	}
}
