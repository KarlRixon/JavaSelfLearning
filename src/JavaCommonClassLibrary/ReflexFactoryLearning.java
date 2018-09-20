package JavaCommonClassLibrary;

// 利用反射实现工厂设计模式

interface Fruit{
	public void eat();
}

class Apple implements Fruit{
	@Override
	public void eat() {
		System.out.println("吃苹果！");
	}
}

class Orange implements Fruit{
	@Override
	public void eat() {
		System.out.println("吃橘子！");
	}
}

class Factory{
	public static Fruit getInstance(String className) {
		Fruit f = null;
		try {
			f = (Fruit)Class.forName(className).newInstance();
		}catch(Exception e) {}
		return  f;
	}
}

public class ReflexFactoryLearning {
	public static void main(String[] args) {
		Fruit fa = Factory.getInstance("JavaCommonClassLibrary.Apple");
		Fruit fb = Factory.getInstance("JavaCommonClassLibrary.Orange");
		fa.eat();
		fb.eat();
	}
}
