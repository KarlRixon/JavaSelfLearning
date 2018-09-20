package JavaCommonClassLibrary;

// final表示终结器，用于定义不能被继承的父类、不能被覆写的方法和常量
// finally是异常处理的出口
// finalize是Object类的一个方法，用于执行对象回收前的收尾操作
public class SystemLearning {
	public static class Human{
		public Human() {
			System.out.println("造人成功");
		}
		@Override
		// 当一个对象的堆内存空间被回收后自动调用finalize方法进行回收前的收尾工作，此方法出现任何错误或异常都不会影响程序正常执行
		protected void finalize() throws Throwable{
			System.out.println("活了100岁，是时候了");
			throw new Exception("此处即使发生异常也不会尝试任何影响");
		}
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String str = "";
		for(int i=0; i<30000; i++) {
			str+=i;
		}
		long end = System.currentTimeMillis();
		System.out.println("本次操作花费时间："+(end-start)+"ms\t"+(end-start)/1000+"s");
		
		Human men = new Human();
		men = null;
		System.gc();
	}
}
