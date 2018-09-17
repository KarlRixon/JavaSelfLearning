package cn.karlrixon;

// 多个线程同时操作同一个资源时就有可能出现不同步问题，使用线程休眠更容易观察不同步问题
public class asynchronyLearning {
	public static class MyThread implements Runnable{
		private int ticket = 5;
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				if(this.ticket>0) {
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"买票，tickets="+this.ticket--);
				}
			}
		}
	}
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt, "张三").start();
		new Thread(mt, "李四").start();
		new Thread(mt, "王五").start();
		new Thread(mt, "赵六").start();
	}
}
