package link.karlrixon;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args){
//		System.out.println("Hello World!");
		Scanner input=new Scanner(System.in);
		System.out.print("�����뿼�Գɼ���");
		int score=input.nextInt();
		int count=0;
		System.out.println("�ӷ�ǰ�Ĵ�����"+score);
		while(score<60){
			count++;
			score++;
		}
		System.out.println("�ӷֺ�Ĵ�����"+score);
		System.out.println("������"+count+"�Σ�");
	}
}
