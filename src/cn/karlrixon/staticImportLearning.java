package cn.karlrixon;

import static cn.karlrixon.MyMath.*;

public class staticImportLearning {
	public static void main(String[] args) throws Exception {
		System.out.println(div(10, 2));		// 使用静态导入就可以不使用类名称进行调用了
	}
}
