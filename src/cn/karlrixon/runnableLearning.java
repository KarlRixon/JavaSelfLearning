package cn.karlrixon;

public class runnableLearning {
	@FunctionalInterface
	// 多线程优先选Runnable，可以有效避免单继承局限
	public interface Runnable{
		public void run();
	}
	public static class MyThread implements Runnable, java.lang.Runnable{
		private String name;
		public MyThread(String name) {
			this.name = name;
		}
		@Override
		public void run() {
			for(int x = 0; x < 200; x++) {
				System.out.println(this.name+"-->"+x);
			}
		}
	}
	public static void main(String[] args) {
		MyThread mt1 = new MyThread("线程A");
		MyThread mt2 = new MyThread("线程B");
		MyThread mt3 = new MyThread("线程C");
		new Thread(mt1).start();
		new Thread(mt2).start();
		new Thread(mt3).start();
	}
}
