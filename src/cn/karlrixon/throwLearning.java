package cn.karlrixon;

public class throwLearning {
	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
