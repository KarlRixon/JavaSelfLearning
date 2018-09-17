package cn.karlrixon;

// 优先级（1-10）越高，越可能先执行
public class threadPriorityLearning {
	public static class MyThread implements Runnable{
		@Override
		public void run() {
			for(int i=0; i < 10000; i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+", i="+i+"优先级："+Thread.currentThread().getPriority());
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("主方法优先级："+Thread.currentThread().getPriority());
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt, "线程A");
		Thread t2 = new Thread(mt, "线程B");
		Thread t3 = new Thread(mt, "线程C");
		t3.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
