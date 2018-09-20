package JavaCommonClassLibrary;

import java.util.Arrays;
import java.util.Comparator;

// 如果设计一个类时没有考虑到排序的需求但后来需要排序
// 可以用Java的Comparator接口进行补救
// 这是一个函数式接口
public class ComparatorInterfaceLearning {
	// 定义一个类，不实现比较器
	public static class Book {
		private String title;
		private double price;
		public Book() {}
		public Book(String title, double price) {
			this.title = title;
			this.price = price;
		}
		@Override
		public String toString() {
			return "书名："+this.title+"，价格："+this.price+"\n";
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	}
	
	// 后来使用Comparator接口为Book类补充了一个排序规则类
	public static class BookComparator implements Comparator<Book>{
		@Override
		public int compare(Book o1, Book o2) {
			if(o1.getPrice() > o2.getPrice()) {
				return 1;
			}else if(o1.getPrice() < o2.getPrice()) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		Book books[] = new Book[] {
			new Book("Java开发实战经典", 79.8),
			new Book("JavaWEB开发实战经典", 69.8),
			new Book("Oracle开发实战经典", 99.8),
			new Book("Android开发实战经典", 89.8),
		};
		Arrays.sort(books, new BookComparator());
		System.out.println(Arrays.toString(books));
	}
}
