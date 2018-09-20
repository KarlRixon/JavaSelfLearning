package JavaCommonClassLibrary;

import java.io.IOException;

// 可以到运行配置中定义相关参数
// Runtime还可以调用本机可执行程序并创建进程
public class RuntimeLearning {
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime run = Runtime.getRuntime();	//取得runtime实例化对象
		System.out.println("MAX = "+run.maxMemory()+"\t"+run.maxMemory()/8/1024/1024+"MB");			//最大可用内存
		System.out.println("TOTAL = "+run.totalMemory()+"\t"+run.totalMemory()/8/1024/1024+"MB");	//全部可用内存
		System.out.println("FREE = "+run.freeMemory()+"\t"+run.freeMemory()/8/1024/1024+"MB");		//空闲内存
		
		String str = "";
		for(int i=0; i<2000; i++) {
			str+=i;
		}
		System.out.println("【垃圾处理前】MAX = "+run.maxMemory()+"\t"+run.maxMemory()/8/1024/1024+"MB");			//最大可用内存
		System.out.println("【垃圾处理前】TOTAL = "+run.totalMemory()+"\t"+run.totalMemory()/8/1024/1024+"MB");	//全部可用内存
		System.out.println("【垃圾处理前】FREE = "+run.freeMemory()+"\t"+run.freeMemory()/8/1024/1024+"MB");		//空闲内存
		run.gc();		// 调用垃圾收集器释放无用内存
		System.out.println("【垃圾处理后】MAX = "+run.maxMemory()+"\t"+run.maxMemory()/8/1024/1024+"MB");			//最大可用内存
		System.out.println("【垃圾处理后】TOTAL = "+run.totalMemory()+"\t"+run.totalMemory()/8/1024/1024+"MB");	//全部可用内存
		System.out.println("【垃圾处理后】FREE = "+run.freeMemory()+"\t"+run.freeMemory()/8/1024/1024+"MB");		//空闲内存
		
		Process pro = run.exec("mspaint.exe");
		Thread.sleep(2000);
		pro.destroy();
		
//		Process pro = run.exec("C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe");
//		Thread.sleep(2000);
	}
}
