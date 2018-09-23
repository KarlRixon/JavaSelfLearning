package JavaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		// 判断输入内容
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while(flag) {
			System.out.println("输入年龄：");
			String str = buf.readLine();
			if(str.matches("\\d{1,3}")) {
				System.out.println("年龄是："+Integer.parseInt(str));
				flag = false;
			}else {
				System.out.println("输入年龄错误，年龄必须是数组组成");
			}
		}
		
		// 读取文件
		File file = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test3.txt");
		// 使用文件输入流实例化BufferedReader类对象
		BufferedReader buf2 = new BufferedReader(new FileReader(file));
		String str2 = null;
		while((str2 = buf2.readLine()) != null) {
			System.out.println(str2);
		}
		buf2.close();
	}
}
