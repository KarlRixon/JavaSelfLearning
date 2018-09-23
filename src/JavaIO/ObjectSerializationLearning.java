package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class Book implements Serializable{
	private String title;
	private double price;
	public Book(String title, double price) {
		this.price = price;
		this.title = title;
	}
	@Override
	public String toString() {
		return "书名："+this.title+"，价格："+this.price;
	}
}

public class ObjectSerializationLearning {
	public static void ser() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\oostest")));
		oos.writeObject(new Book("Java开发", 79.8));			// 序列化对象
		oos.close();
	}
	public static void dser() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				new File("C:\\Users\\24346\\Documents\\Java\\HelloWorld\\src\\JavaIO\\oostest")));
		Object obj = ois.readObject();			// 反序列化对象
		Book book = (Book)obj;					// 转型
		System.out.println(book);
		ois.close();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// 实现序列化对象操作--ObjectOutputStream
		ser();
		// 实现反序列化操作
		dser();
		// 此外如果对象中的一些属性在序列化时不需要保存，就可以通过transient关键字
	}
}
