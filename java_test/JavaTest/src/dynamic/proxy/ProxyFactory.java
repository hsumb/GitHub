package dynamic.proxy;

import java.lang.reflect.Proxy;
public class ProxyFactory {
	public static Object newInstance(Object ob) {
		return Proxy.newProxyInstance(ob.getClass().getClassLoader(),
				new Class<?>[] { Rectangle.class }, new MyInvocationHandler(ob));
	}
}