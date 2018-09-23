package JavaIO;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

// java.io操作文件过程中会出现延迟情况，因为Java程序是通过JVM间接调用操作系统的文件处理函数
public class FileLearning {
	public static void main(String[] args) throws IOException {
		// 文件创建和删除、判断存在
		File file = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test.txt");
		if(file.exists()) {
			//file.delete();
			System.out.println("file exists");
		}else {
			System.out.println(file.createNewFile());
		}
		
		// 创建带路径文件
		// 先判断父路径是否存在，否则创建文件会报错
		File file2 = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO"+File.separator+"demo"+File.separator+"test.txt");
		if(!file2.getParentFile().exists()) {
			file2.getParentFile().mkdirs();
		}
		System.out.println(file2.createNewFile());
		
		// 取得文件或目录的信息
		if(file2.exists()) {
			System.out.println("-是否是文件："+file2.isFile());
			System.out.println("-是否是目录："+file2.isDirectory());
			// 文件大小是字节为单位的数字
			// 考虑到小数点问题，使用BigDecimal进行单位转换处理
			System.out.println("-文件大小："+(new BigDecimal((double)file2.length()/1024/1024).
					divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP))+"M");
			// 返回的日期是long的形式，可以利用SimpleDateFormat进行格式化
			System.out.println("-上次修改时间："+new SimpleDateFormat("yyyy-mm-dd hh:mmLss")
					.format(new Date(file2.lastModified())));
		}
		
		// 列出目录信息
		File file3 = new File("d:");
		System.out.println("-是否是目录："+file3.isDirectory());
		if(file3.isDirectory()) {
			File result[] = file3.listFiles();
			for(int i=0; i<(result.length<5?result.length:5); i++) {
				System.out.println(result[i]);		// 调用toString
			}
		}
		
		// 列出目录下所有文件及子目录信息
		System.out.println("------------");
		File file4 = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO");
		print(file4);
	}
	public static void print(File file) {		// 递归显示目录所有内容
		if(file.isDirectory()) {
			File result[] = file.listFiles();
			if(result != null) {
				for(int i=0; i<result.length; i++) {
					print(result[i]);
				}
			}
		}
		System.out.println(file);
	}
}
