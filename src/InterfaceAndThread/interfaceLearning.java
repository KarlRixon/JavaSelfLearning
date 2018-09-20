package InterfaceAndThread;

public class interfaceLearning {
	interface USB{
		public static final String startInfo = "开始工作！";
		public static final String stopInfo = "停止工作！";
		public abstract void start();
		public abstract void stop();
	}
	public static class Computer{
		public void plugin(USB usb) {
			usb.start();
			usb.stop();
		}
	}
	public static class Flash implements USB{
		public void start() {
			System.out.println("Flash "+startInfo);
		}
		public void stop() {
			System.out.println("Flash "+stopInfo);
		}
	}
	public static class Print implements USB{
		public void start() {
			System.out.println("Print "+startInfo);
		}
		public void stop() {
			System.out.println("Print "+stopInfo);
		}
	}
	public static class MP3 implements USB{
		public void start() {
			System.out.println("MP3 "+startInfo);
		}
		public void stop() {
			System.out.println("MP3 "+stopInfo);
		}
	}
	public static void main(String[] args) {
		Computer com = new Computer();
		com.plugin(new Flash());
		com.plugin(new Print());
		com.plugin(new MP3());
	}
}