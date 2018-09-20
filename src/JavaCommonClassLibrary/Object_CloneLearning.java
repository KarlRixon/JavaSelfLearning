package JavaCommonClassLibrary;

public class Object_CloneLearning {
	public static class Book implements Cloneable{		// 此类对象可以被克隆
		private String title;
		private double price;
		public Book(String title, double price) {
			this.price = price;
			this.title = title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		@Override
		public String toString() {
			return "书名："+this.title+"\t价："+this.price;
		}
		@Override
		public Object clone() throws CloneNotSupportedException{
			return super.clone();		// 调用父类的克隆方法
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Book bookA = new Book("Java开发", 79.8);
		Book bookB = (Book)bookA.clone();
		bookB.setTitle("JSP开发");
		System.out.println(bookA);
		System.out.println(bookB);
	}
}
