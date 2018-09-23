package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

// 字节流：InputStream OutputStream
// 子类： FileInputStream FileOutputStream
// 字符流：Reader Writer
// 子类：FileWriter FileReader
// 流的基本操作形式
// 1.用File类定义要操作文件的路径
// 2.字节流或字符流的子类为父类对象实例化
// 3.数据读写
// 4.资源关闭
// 字节与字符的区别：字节流直接与终端文件进行数据交互，字符流需要经过数据缓冲区处理才与终端文件数据交互，可以使用flush()强制清空缓冲区
public class ByteAndCharacterStream {
	public static void main(String[] args) throws IOException {
		// 字节文件内容输出
		File file = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 使用OutputStream及子类FileOutputStream进行实例化
		//OutputStream output = new FileOutputStream(file, true);		// 追加操作
		OutputStream output = new FileOutputStream(file);				// 不追加
		String str = "hello you have written me\n";
		byte data[] = str.getBytes();		// 将字符串变为字节数组
		output.write(data);					// 输出内容
		output.close();						// 关闭资源
		// 单字节操作
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+",");
		}System.out.println();
		
		// 字节文件数据读取
		if(!file.exists()) {
			System.out.println("file error");
		}else {
			InputStream input = new FileInputStream(file);
			byte data2[] = new byte[1024];					// 准备一个指定大小的数组
			int len = input.read(data2);					// 读取数据，保存到字节数组
			input.close();									// 关闭资源
			System.out.println("文件大小："+len);
			System.out.println(new String(data2, 0, len));
		}
		// 循环实现输入流（逐字节读取）
		if(file.exists()) {
			InputStream input2 = new FileInputStream(file);
			byte data3[] = new byte[1024];
			int foot = 0;
			int temp = 0;
			while((temp = input2.read()) != -1) {
				data3[foot++] = (byte)temp;
			}
			input2.close();
			System.out.println("-----------------------\n");
			System.out.println(new String(data3, 0, foot));
		}
		
		// 字符文件内容输出
		File file2 = new File("C:\\\\Users\\\\24346\\\\Documents\\\\Java\\\\HelloWorld\\\\src\\\\JavaIO\\\\test2.txt");
		if(!file2.getParentFile().exists()) {		// 判断目录是否存在
			file.getParentFile().mkdirs();			// 创建目录
		}
		Writer out = new FileWriter(file2);
		//Writer out = new FileWriter(file2, true);		// 追加
		String str2 = "KarlRixon";
		out.write(str2);
		out.close();
		
		// 字符文件内容读取
		if(file2.exists()) {
			Reader in = new FileReader(file2);
			char instr[] = new char[1024];
			int len2 = in.read(instr);
			in.close();
			System.out.println(new String(instr, 0, len2));
		}
	}
}
