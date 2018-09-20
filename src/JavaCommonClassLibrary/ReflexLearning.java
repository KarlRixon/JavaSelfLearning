package JavaCommonClassLibrary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

class Book {
	public Book() {
		System.out.println("----Book类的无参构造方法");
	}
	@Override
	public String toString() {
		return "名师讲坛--java开发经典";
	}
}

class Book2 {
	private String title;
	private double price;
	public Book2(String title, double price) {
		this.price = price;
		this.title = title;
	}
	@Override
	public String toString() {
		return "书名："+this.title+"，价格："+this.price;
	}
}

class Book3 {
	private String title;
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
}

class Book4 {
	private String title;
}

public class ReflexLearning {
	public static String initcap(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Date date = new Date();
		System.out.println(date.getClass());
		
		// Class类对象实例化
		Class<?> cls = date.getClass();		// 通过实例化对象取得Class对象
		System.out.println(cls.getName());	// 获得所在类名称
		
		Class cls2 = java.util.Date.class;	// 通过类名称获取Class类对象
		System.out.println(cls2.getName());	// 获取类名
		
		Class<?> cls3 = Class.forName("java.util.Date");
		System.out.println(cls3.getName());
		
		// 利用Class类进行反射控制
		// 利用反射实例化对象
		Class<?> cls4 = Class.forName("JavaCommonClassLibrary.Book");
		Object obj = cls4.newInstance();	// 实例化返回的都是Object对象
		Book book = (Book)obj;
		System.out.println(book);
		
		// 明确调用类中的有参构造
		Class<?> cls5 = Class.forName("JavaCommonClassLibrary.Book2");
		Constructor<?> con = cls5.getConstructor(String.class, double.class);	// 明确找到Book2中的某个带参构造
		Object obj2 = con.newInstance("Java开发实战经典", 79.8);
		System.out.println(obj2);
		
		// 利用反射操作简单Java类属性
		// 反射调用方法
		String fieldName = "title";
		Class<?> cls6 = Class.forName("JavaCommonClassLibrary.Book3");
		Object obj3 = cls6.newInstance();
		Method setMet = cls6.getMethod("set"+initcap(fieldName), String.class);
		Method getMet = cls6.getMethod("get"+initcap(fieldName));
		setMet.invoke(obj3, "Java源码分析实录");			// 使用invoke调用目标方法
		System.out.println(getMet.invoke(obj3));
		
		// 反射调用私有成员
		Class<?> cls7 = Class.forName("JavaCommonClassLibrary.Book4");
		Object obj4 = cls7.newInstance();
		Field titleField = cls7.getDeclaredField("title");
		titleField.setAccessible(true);
		titleField.set(obj4, "Java绝密宝典");
		System.out.println(titleField.get(obj4));
	}
}
