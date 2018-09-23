package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyDemo {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		if(args.length != 2) {
			System.out.println("命令执行错误");
			System.exit(1);
		}
		// 若参数个数正确，进行源文件有效性验证
		File inFile = new File(args[0]);
		if(!inFile.exists()) {
			System.out.println("源文件不存在");
			System.exit(1);
		}
		// 若源文件有效，定义输出文件，考虑到输出文件有目录
		File outFile = new File(args[1]);
		if(!outFile.getParentFile().exists()) {
			outFile.getParentFile().mkdirs();
		}
		// 实现文件内容复制
		InputStream input = new FileInputStream(inFile);
		OutputStream output = new FileOutputStream(outFile);
		int temp = 0;
		byte data[] = new byte[1024];
		while((temp = input.read(data)) != -1) {
			output.write(data, 0, temp);
		}
		input.close();
		output.close();
		long end = System.currentTimeMillis();
		System.out.println("参数："+args[0]+" "+args[1]);
		System.out.println("复制所花时间："+(end-start));
	}
}
