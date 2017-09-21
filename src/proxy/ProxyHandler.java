package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yuhaowang on 9/18/17.
 */
public class ProxyHandler implements InvocationHandler {

    private Object subject;

    public ProxyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before calling method，what should we do?");

        System.out.println("Method: " + method);

        Object returnValue = method.invoke(subject, args);

        System.out.println("After calling method，what should we do?");
        return returnValue;
    }
}
