package JavaIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

// 字节流和字符流可以相互转换
// 使用InputStreamReader和OutputStreamWriter两个类
public class ConversionFlowLearning {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\test2.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		OutputStream output = new FileOutputStream(file);
		// 将OutputStream类对象传递给OutputStreamWriter类的构造方法，然后向上转型
		Writer out = new OutputStreamWriter(output);
		out.write("hi\n");
		out.flush();
		out.close();
	}
}
