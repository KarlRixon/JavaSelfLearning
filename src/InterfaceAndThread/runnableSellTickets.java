package InterfaceAndThread;

public class runnableSellTickets {
	public static int tickets = 50;
	public static class MyThread implements Runnable{
		private String name;
		private int t = 0;
		public MyThread(String name) {
			this.name = name;
		}
		public void cal() {
			System.out.println(this.name+"买了"+this.t+"张票");
		}
		@Override
		public void run() {
			for(; tickets > 0; ) {
				if(tickets > 0) {
					System.out.println(this.name+"买票，tickets = "+tickets--);
					this.t++;
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread mt1 = new MyThread("张三");
		MyThread mt2 = new MyThread("李四");
		MyThread mt3 = new MyThread("王五");
		Thread mt11 = new Thread(mt1);
		Thread mt22 = new Thread(mt2);
		Thread mt33 = new Thread(mt3);
		mt11.start();
		mt22.start();
		mt33.start();
		mt11.join(100);
		mt22.join(100);
		mt33.join(100);
		mt1.cal();
		mt2.cal();
		mt3.cal();
	}
}
