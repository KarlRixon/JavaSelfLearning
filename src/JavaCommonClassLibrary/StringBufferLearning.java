package JavaCommonClassLibrary;

// String类内容一旦声明则不可改变，而StringBuffer类与StringBuilder类声明的内容可以改变
// StringBuffer提供的都是同步方法，属于安全的线程操作
// StringBuilder提供的都是异步方法，属于非线程的安全操作
// 此外StringBuffer与StringBuilder没有区别
public class StringBufferLearning {
	public static void main(String[] args) throws Exception{
		StringBuffer buf = new StringBuffer();
		buf.append("Hello ").append("World").append("!");
		change(buf);
		System.out.println(buf);
		
		CharSequence seq = "hi";// 向上转型
		System.out.println(seq);// String类覆写的toString
		
		// 用String构造StringBuffer
		StringBuffer buf2 = new StringBuffer("hhhhhh");
		System.out.println(buf2);
		
		// 用toString将StringBuffer转化为String
		String str = buf2.toString();
		System.out.println(str);
		
		// 用StringBuffer构造String
		//String str2 = String(new StringBuffer("233333"));
		
		System.out.println("Hello World!\nKarlRixon".equals(buf));
		System.out.println("hhhhhh".equals(buf2));
		StringBuffer buf3 = new StringBuffer();
		buf3.append("666");
		System.out.println("666".equals(buf3));
		System.out.println("hi".equals(seq));
		
		// 反转
		System.out.println(buf.reverse());
		
		// 插入
		buf.reverse().insert(0, "wwwww ");
		System.out.println(buf);
		
		// 删除
		buf.delete(0, 6);
		System.out.println(buf);
	}
	// 在change中对StringBuffer对象的修改可以影响原始对象
	public static void change(StringBuffer temp) {
		temp.append("\nKarlRixon");
	}
}
