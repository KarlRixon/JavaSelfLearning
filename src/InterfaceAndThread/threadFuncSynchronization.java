package InterfaceAndThread;

// 多个线程同时操作同一个资源时就有可能出现不同步问题，解决方法是同步代码块和同步方法，可以保证无论何时资源只被一个线程操作
// 本例为同步方法
public class threadFuncSynchronization {
	public static class MyThread implements Runnable{
		private int ticket = 40;
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				this.sale();
			}
		}
		public synchronized void sale() {	// 同步代码块
			if(this.ticket>0) {
				System.out.println(Thread.currentThread().getName()+"买票，tickets="+this.ticket--);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		MyThread mt = new MyThread();
		new Thread(mt, "张三").start();
		new Thread(mt, "李四").start();
		new Thread(mt, "王五").start();
		new Thread(mt, "赵六").start();
	}
}
