package cn.karlrixon;

public class objectLearning {
	public static class Book{
		private String name;
		private double price;
		public Book(String name, double price) {
			this.name = name;
			this.price = price;
		}
		public String toString() {
			return "书名："+name+"\t价格："+price;
		}
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Book)) {
				return false;
			}
			Book book = (Book)obj;
			if(this.name.equals(book.name) && this.price == book.price) {
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		Book book1 = new Book("三体", 35.9);
		Book book2 = new Book("多面体", 35.9);
		Book book3 = new Book("三体", 35.9);
		String string = new String("hello");
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(string);
		System.out.println(book1.equals(book3));
		System.out.println(book1.equals(book2));
		System.out.println(book1.equals(string));
	}
}
