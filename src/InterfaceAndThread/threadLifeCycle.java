package InterfaceAndThread;

// suspend 暂时挂起线程
// resume 恢复挂起进程
// stop 停止线程
// 以上三个方法已经慢慢废除了，主要原因是会产生死锁问题
// 一般通过设置标志位来停止一个线程运行
public class threadLifeCycle {
	public static class MyThread implements Runnable{
		private boolean flag = true;
		public void run() {
			int i = 0;
			while(this.flag) {
				//while(true) {
					System.out.println(Thread.currentThread().getName()+"运行，i="+(i++));
				//}
			}
		}
		public void stop() {
			this.flag = false;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt, "线程");
		t.start();
		Thread.sleep(1000);
		mt.stop();
	}
}
