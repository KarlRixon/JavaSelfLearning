package InterfaceAndThread;

import java.util.Scanner;

public class factoryLearning {
	interface Fruit{
		public abstract void eat();
	}
	public static class orange implements Fruit{
		public void eat() {
			System.out.println("吃橘子");
		}
	}
	public static class apple implements Fruit{
		public void eat() {
			System.out.println("吃苹果");
		}
	}
	public static class Factory{
		public static Fruit getInstance(String className) {
			if("apple".equals(className)) {
				return new apple();
			}else if ("orange".equals(className)) {
				return new orange();
			}else {
				return null;
			}
		}
	}
	public static void main(String[] args) {
		String[] fruits = {"apple", "orange"};
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("选择要吃的水果：苹果（1）橘子（2）不吃了（3）");
			int index = input.nextInt();
			if(index == 3) {
				System.out.println("吃饱了");
				input.close();
				return;
			}
			Fruit fruit = Factory.getInstance(fruits[index-1]);
			fruit.eat();
		}
	}
}
