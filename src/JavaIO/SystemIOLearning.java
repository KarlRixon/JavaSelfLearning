package JavaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class SystemIOLearning {
	public static void main(String[] args) throws IOException {
		// 错误输出
		try {
			Integer.parseInt("abc");
		}catch(Exception e) {
			System.err.println(e);
		}
		
		// 信息输出
		OutputStream out = System.out;
		out.write("Hello\n".getBytes());

		// 系统输入
		// 使用字节数组接受
		InputStream input = System.in;
		byte data[] = new byte[1024];
		System.out.print("请输入数据：");
		int len = input.read(data);
		System.out.println("载入数据为："+new String(data, 0, len));
		System.out.println("数据大小为："+len+"byte");
		
		// 使用数组接受输入存在漏读问题，而StringBuffer对象接受则没有数据长度限制
		StringBuffer buf = new StringBuffer();
		System.out.print("输入数据：");
		int temp = 0;
		while((temp = input.read()) != -1) {
			if(temp == '\n') {
				break;
			}
			buf.append((char)temp);
		}
		System.out.println("输入数据为："+buf);
		
		// 由于是单字节读取，输入汉字就会变乱码，使用字符缓冲输入流可以解决此问题
		// System.in是InputStream类对象，BufferedReader的构造方法需要接受Reader对象
		// 利用InputStreamReader将字节流对象变为字符流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("输入数据：");
		String str = br.readLine();
		System.out.println("输入为："+str);
		// 与BufferedInputStream相比BufferedReader更适合处理中文、字符串，因为有readLine之类的方法
	}
}
