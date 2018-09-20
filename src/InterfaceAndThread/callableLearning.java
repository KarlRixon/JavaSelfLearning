package InterfaceAndThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class callableLearning {
	public static class MyThread implements Callable<String>{
		private int ticket = 10;
		@Override
		public String call() throws Exception{
			for(int x = 0; x < 100; x++) {
				if(ticket > 0) {
					System.out.println("买票，ticket = "+ticket--);
				}
			}
			return "票已卖光";
		}
	}
	public static void main(String[] args) throws Exception{
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
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
