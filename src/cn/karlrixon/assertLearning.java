package cn.karlrixon;

public class assertLearning {
	public static void main(String[] args) {
		int num = 10;
		// 需要用 `java -ea cn.karlrixon.assertLearning` 来开启断言
		assert num == 20 : "num的值不为20";
		System.out.println(num);
	}
}
