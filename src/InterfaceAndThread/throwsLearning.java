package InterfaceAndThread;

public class throwsLearning {
	public static class MyMath{
		public static int div(int x, int y) throws Exception{
			return x/y;
		}
	}
	public static void main(String[] args) {
		try {
			System.out.println(MyMath.div(10, 2));
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(MyMath.div(10, 0));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
