package InterfaceAndThread;

public class threadSleepLearning {
	public static class MyThread implements Runnable{
		@Override
		public void run() {
			for(int i=0; i < 10000; i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+", i="+i);
			}
		}
	}
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt, "自己的线程A").start();
	}
}
