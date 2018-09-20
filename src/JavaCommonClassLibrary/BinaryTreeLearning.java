package JavaCommonClassLibrary;

import java.util.Arrays;

// 节点可比较、可字符串化的二叉树数据结构
public class BinaryTreeLearning {
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
	public static class BinaryTree{
		private class Node{
			private Comparable data;		//排序的依据是Comparable
			private Node left;				//左节点
			private Node right;				//右节点
			public Node(Comparable data) {	//构造方法
				this.data = data;
			}
			@SuppressWarnings("unchecked")
			public void addNode(Node newNode) {
				if(this.data.compareTo(newNode.data)>0) {
					if(this.left == null) {
						this.left = newNode;
					}else {
						this.left.addNode(newNode);
					}
				}else {
					if(this.right == null) {
						this.right = newNode;
					}else {
						this.right.addNode(newNode);
					}
				}
			}
			public void toArrayNode() {
				if(this.left != null) {
					this.left.toArrayNode();
				}
				BinaryTree.this.retData[BinaryTree.this.foot++] = this.data;
				if(this.right != null) {
					this.right.toArrayNode();
				}
			}
		}
		private Node root;						// 根节点
		private int count;						// 节点个数
		private Object[] retData;				// 保存返回对象的数组
		private int foot;						// 操作脚标
		public void add(Object obj) {			// 数据追加
			Comparable com = (Comparable)obj;	// 转为Comparable才可以数铣Node保存
			Node newNode = new Node(com);
			if(this.root == null) {
				this.root = newNode;
			}else {
				this.root.addNode(newNode);		// 交给Node类处理
			}
			this.count++;
		}
		public Object[] toArray() {				// 取得全部保存数据
			if(this.root == null) {
				return null;
			}
			this.foot = 0;
			this.retData = new Object[this.count];
			this.root.toArrayNode();
			return this.retData;
		}
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(new Book("Java开发实战经典", 79.8));
		bt.add(new Book("JavaWEB开发实战经典", 69.8));
		bt.add(new Book("Oracle开发实战经典", 99.8));
		bt.add(new Book("Android开发实战经典", 89.8));
		Object obj[] = bt.toArray();
		System.out.println(Arrays.toString(obj));
	}
}
