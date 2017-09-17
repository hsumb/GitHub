package dynamic.proxy;

public class Task {
	public static void main(String[] args) {
		Rectangle square = (Rectangle)ProxyFactory.newInstance(new Square());
		square.setBase(5);
		square.setHeight(3);
		System.out.println(square.getArea());
	}
}