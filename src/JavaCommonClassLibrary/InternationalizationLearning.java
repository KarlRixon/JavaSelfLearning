package JavaCommonClassLibrary;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationLearning {
	public static void main(String[] args) {
		// 使用Local类定义语言环境
		Locale loc = Locale.getDefault();
		System.out.println(loc);
		
		// 利用ResourceBundle读取资源文件
		ResourceBundle rb = ResourceBundle.getBundle("JavaCommonClassLibrary.Message");
		System.out.println(rb.getString("karl"));
		
		// 读取数据并动态设置内容
		System.out.println(MessageFormat.format(rb.getString("karl"),"www.karlrixon.link","Karl"));
	}
}

