package proxy;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * Created by yuhaowang on 9/18/17.
 */
public class DynamicProxyClient {
    public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject();
        ProxyHandler handler = new ProxyHandler(concreteSubject);
        ClassLoader loader = concreteSubject.getClass().getClassLoader();
        Class[] interfaces = concreteSubject.getClass().getInterfaces();
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println("The type of Dynamic Proxy Object: " + subject.getClass().getName());

        subject.doSomething();


        createlog();
    }

    private static void createlog() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        try {
            FileOutputStream out = new FileOutputStream(name + ".class");
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

