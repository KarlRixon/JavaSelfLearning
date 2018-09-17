package cn.karlrixon;

// 同步就是一个线程需要等待另一个线程执行完成才能继续执行的操作方式，虽然同步可以保证资源共享操作的正确性，但过多同步也会产生问题
// 例如张三需要李四的画才能给李四书，而李四需要张三的书才能给张三画，这样就陷入了死锁
// 注意：一下程序没有任何意义
public class threadDeadLockLearning2 {
	public static class A{
		public synchronized void say(B b) {
			System.out.println("A说：先给我本，就给你笔，否则不给");
			this.get(b);
			this.give(b);
		}
		public synchronized void get(B b) {
			b.give(this);
		}
		public synchronized void give(B b) {
			b.get(this);
		}
	}
	public static class B{
		public synchronized void say(A a) {
			System.out.println("B说：先给我笔，就给你本，否则不给");
			this.get(a);
			this.give(a);
		}
		public synchronized void get(A a) {
			a.get(this);
		}
		public synchronized void give(A a) {
			a.give(this);
		}
	}
	public static class Test implements Runnable{
		private static A a = new A();
		private static B b = new B();
		public Test() {
			new Thread(this).start();
			b.say(a);
		}
		@Override
		public void run() {
			a.say(b);
		}
	}
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		//new Thread(test).start();
		System.out.println("没有发生死锁");
	}
}
