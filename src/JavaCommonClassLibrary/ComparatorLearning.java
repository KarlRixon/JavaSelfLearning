package JavaCommonClassLibrary;

import java.util.Arrays;

public class ComparatorLearning {
	public static class Book implements Comparable<Book>{	//实现比较器
		private String title;
		private double price;
		public Book(String title, double price) {
			this.title = title;
			this.price = price;
		}
		@Override
		public String toString() {
			return "书名："+this.title+"，价格："+this.price+"\n";
		}
		@Override
		public int compareTo(Book o) {		//Arrays.sort()会自动调用此方法比较
			if(this.price>o.price) {
				return 1;
			}else if(this.price<o.price) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		//数组类
		//数组排序 二分查找
		int data[] = new int[] {1, 5, 6, 2, 3, 4, 9, 8, 7, 10};
		Arrays.sort(data);
		System.out.println(Arrays.binarySearch(data, 8));
		
		//数组比较
		int data2[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(data.equals(data2));
		System.out.println(Arrays.equals(data, data2));
		
		//数组填充
		int[] data3 = new int[10];
		Arrays.fill(data3, 3);
		System.out.println(Arrays.toString(data3));
		
		//比较器
		Book books[] = new Book[] {
				new Book("Java开发实战经典", 79.8),
				new Book("JavaWEB开发实战经典", 69.8),
				new Book("Oracle开发实战经典", 99.8),
				new Book("Android开发实战经典", 89.8)
		};
		Arrays.sort(books);		//对象数组排序
		System.out.println(Arrays.toString(books));
	}
}
