package link.karlrixon;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args){
//		System.out.println("Hello World!");
		Scanner input=new Scanner(System.in);
		System.out.print("请输入考试成绩：");
		int score=input.nextInt();
		int count=0;
		System.out.println("加分前的创建："+score);
		while(score<60){
			count++;
			score++;
		}
		System.out.println("加分后的创建："+score);
		System.out.println("共加了"+count+"次！");
	}
}
