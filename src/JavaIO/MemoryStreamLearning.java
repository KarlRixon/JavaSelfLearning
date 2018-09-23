package JavaIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 内存字节流、内存字符流
// 写内存：ByteArrayOutputStream CharArrayWriter
// 读内存：ByteArrayInputStream CharArrayReader
public class MemoryStreamLearning {
	public static void main(String[] args) throws IOException {
		// 实现小写字母转大写字母
		String str = "Hello KarlRixon 233";
		// 通过内存操作流实现转换，先将数据保存在内存流，再从里面取出每一个数据
		// 将所有要读取数据设置到内存输入流，本次利用向上转型为InputStream类型实例化
		InputStream input = new ByteArrayInputStream(str.getBytes());
		// 使用ByteArrayOutputStream将所有内存流数据取出
		OutputStream output = new ByteArrayOutputStream();
		int temp = 0;
		// 经过此次循环后，所有数据都将保存在内存输出流对象中
		while((temp = input.read()) != -1) {
			// 将读取进来的数据转化为大写字母，利用Character.toUpperCase()可以保证只换字母
			output.write(Character.toUpperCase(temp));
		}
		System.out.println(output);			// 调用toString方法
		input.close();
		output.close();
		
		// 实现文件合并读取
		File fileA = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test.txt");
		File fileB = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test2.txt");
		InputStream inputA = new FileInputStream(fileA);
		InputStream inputB = new FileInputStream(fileB);
		ByteArrayOutputStream output2 = new ByteArrayOutputStream();
		while((temp = inputA.read()) != -1) {
			output2.write(temp);
		}
		while((temp = inputB.read()) != -1) {
			output2.write(temp);
		}
		// 现在所有内容都保存在了内存输出流，所有内容变为字节数组取出
		byte data[] = output2.toByteArray();
		output2.close();
		inputA.close();
		inputB.close();
		System.out.println(new String(data));			// 字节转换为字符串输出
	}
}
