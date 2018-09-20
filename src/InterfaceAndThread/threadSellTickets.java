package InterfaceAndThread;

public class threadSellTickets {
	public static int ticket = 50;
	public static class MyThread extends Thread{
		private int t = 0;
		private String name;
		public MyThread(String name) {
			this.name = name;
		}
		public void cal() {
			System.out.println(this.name+"买了"+this.t+"张票");
		}
		@Override
		public void run() {
			for(; ticket > 0;) {
				if(ticket > 0) {
					System.out.println(this.name+"买票，ticket = "+ticket--);
					this.t++;
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread mt1 = new MyThread("张三");
		MyThread mt2 = new MyThread("李四");
		MyThread mt3 = new MyThread("王五");
		mt1.start();
		mt2.start();
		mt3.start();
		mt1.join(100);
		mt2.join(100);
		mt3.join(100);
		if(ticket == 0) {
			mt1.cal();
			mt2.cal();
			mt3.cal();
		}
	}
}
