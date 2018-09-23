package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerLearning {
	public static void main(String[] args) throws FileNotFoundException {
		// 使用Scanner实现键盘数据输入
		Scanner scan = new Scanner(System.in);
		System.out.print("输入内容：");
		if(scan.hasNext()) {
			System.out.println("输入内容为："+scan.next());
		}
		
		// 输入数字
		System.out.println("输入成绩：");
		if(scan.hasNext()) {
			double score = scan.nextDouble();
			System.out.println("成绩为："+score);
		}else {
			System.out.println("输入错误");
		}
		
		// 正则验证
		System.out.println("输入生日：");
		if(scan.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
			String bir = scan.next("\\d{4}-\\d{2}-\\d{2}");
			System.out.println("生日为："+bir);
		}else {
			System.out.println("输入错误");
		}
		
		scan.close();
		
		// 读取文件
		Scanner scan2 = new Scanner(new FileInputStream(new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test.txt")));
		scan2.useDelimiter("\n");		// 设置读取分隔符
		while(scan2.hasNext()) {			// 循环读取
			System.out.println(scan2.next());
		}
		scan2.close();
	}
}
