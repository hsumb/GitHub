package dynamic.proxy;

public class Square implements Rectangle{
	double base;
	double height;

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return base * height;
	}

	@Override
	public String toString() {
		return "Square [base=" + base + ", height=" + height + "]";
	}
}