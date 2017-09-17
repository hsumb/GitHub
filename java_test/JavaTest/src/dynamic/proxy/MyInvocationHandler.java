package dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	private Object obj;
	public  MyInvocationHandler(Object obj) {
		this.obj = obj;
	}
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result;
		try{
			result = m.invoke(obj, args);
		} catch (InvocationTargetException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
}