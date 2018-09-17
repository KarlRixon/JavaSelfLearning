package cn.karlrixon;

import java.util.Scanner;

public class exceptionLearning {
	public static void main(String[] args) {
		System.out.println("除法计算开始");
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("输入x:");
			int x = input.nextInt();
			System.out.print("输入y:");
			int y = input.nextInt();
			System.out.println("除法计算："+x/y);
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}finally {
			System.out.println("### 不管有无异常我都执行！");
		}
		System.out.println("除法计算结束");
		input.close();
	}
}
