package cn.karlrixon;

public class VariableParameterLearning {
	public static int add(int ... data) {
		int sum = 0;
		for(int x = 0; x < data.length; x ++) {
			sum += data[x];
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(add(new int[] {1,2,3}));
		System.out.println(add(new int[] {10,20}));
		System.out.println(add(1,2,3));
		System.out.println(add(10,20));
		System.out.println(add());
	}
}
