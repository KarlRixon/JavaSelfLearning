package cn.karlrixon;

public class proxyLearning {
	interface Network{
		public void browse();
	}
	public static class Real implements Network{
		public void browse() {
			System.out.println("上网浏览信息");
		}
	}
	public static class Proxy implements Network{
		private Network network;
		public Proxy(Network network) {
			this.network = network;
		}
		public void check() {
			System.out.println("检查用户是否合法，使用代理");
		}
		public void browse() {
			this.check();
			this.network.browse();
		}
	}
	public static void main(String[] args) {
		Network net = null;
		net = new Proxy(new Real());
		net.browse();
	}
}
