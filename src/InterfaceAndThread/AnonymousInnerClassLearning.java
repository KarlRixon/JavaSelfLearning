package InterfaceAndThread;

public class AnonymousInnerClassLearning {
	interface Message{
		public void print();
	}
	public static void fun(Message msg) {
		msg.print();
	}
	public static void main(String[] args) {
		fun(new Message() {
			public void print() {
				System.out.println("hello world");
			}
		});
	}
}
