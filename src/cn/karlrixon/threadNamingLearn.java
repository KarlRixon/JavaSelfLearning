package cn.karlrixon;

public class threadNamingLearn {
	public static class MyThread implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) throws Exception {
		MyThread mt = new MyThread();
		
		Thread a = new Thread(mt, "自己的线程A");
		a.start();
		a.join();
		
		Thread b = new Thread(mt);
		b.start();
		b.join();
		
		Thread c = new Thread(mt, "自己的线程B");
		c.start();
		c.join();
		
		Thread d = new Thread(mt);
		d.start();
		d.join();
		
		Thread e = new Thread(mt);
		e.start();
		e.join();
		
		MyThread mt2 = new MyThread();
		Thread f = new Thread(mt2, "自己的线程对象");
		f.start();
		f.join();
		
		mt2.run();
	}
}
