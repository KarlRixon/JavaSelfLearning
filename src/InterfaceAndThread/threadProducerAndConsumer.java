package InterfaceAndThread;

// 本例中使用wait和notify方法防止重复生产同一种产品，即避免数据重复
// wait：线程进入等待模式	notify：唤醒等待的进程
public class threadProducerAndConsumer {
	public static class Condom{
		private String title;
		private String content;
		private boolean flag = true;	// true表示只可生产，false表示只可消费
		public synchronized void set(String title, String content) {
			if(this.flag == false) {
				try {
					super.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.title = title;
//			try {
//				Thread.sleep(200);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
			this.content = content;
			this.flag = false;	// 完成生产，修改标志位
			super.notify();		// 唤醒等待进程
		}
		public synchronized void get() {
			if(this.flag == true) {
				try {
					super.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
//			try {
//				Thread.sleep(100);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
			this.flag = true;	// 完成消费，修改标志位
			super.notify();		// 唤醒等待进程
			System.out.println(this.title+"->"+this.content);
		}
	}
	public static class Producer implements Runnable{
		private Condom condom = null;
		public Producer(Condom condom) {
			this.condom = condom;
		}
		@Override
		public void run() {
			for(int i=0; i<50; i++) {
//				try {
//					Thread.sleep(100);
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//				}
				if(i%2==0) {
					this.condom.set("durex", "19.9");
				}else {
					this.condom.set("sixsex", "20.1");
				}
			}
		}
	}
	public static class Consumer implements Runnable{
		private Condom condom = null;
		public Consumer(Condom condom) {
			this.condom = condom;
		}
		@Override
		public void run() {
			for(int i=0; i<50; i++) {
//				try {
//					Thread.sleep(100);
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//				}
				this.condom.get();
			}
		}
	}
	public static void main(String[] args) {
		Condom condom = new Condom();	// 用于生产和消费的对象
		new Thread(new Producer(condom)).start();
		new Thread(new Consumer(condom)).start();
	}
}
