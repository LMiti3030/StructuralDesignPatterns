package mititelu.laura;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {

    private Object obj;

    private SecurityProxy(Object obj){
        this.obj = obj;
    }

    //where the magic happens invoking the calls
    //where the proxy really comes into play
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;
        try{
            if(method.getName().contains("post")){
                throw new IllegalAccessException("Posts are currently not allowed");
            }
            else{
                result = method.invoke(obj,args);
            }

        } catch (InvocationTargetException e){
            throw e.getTargetException();
        } catch (Exception e){
            throw new RuntimeException("Unexpected invocation exception "
            + e.getMessage());
        }

        return result;
    }

    //use java.lang.reflect.Proxy.newProxyInstance to wrap the object
    //builds the proxy around the class and any interfaces it's implementing  and
    //returns Securityproxy object that it's wrapping
    public static Object newInstance(Object object){
        return java.lang.reflect.Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new SecurityProxy(object));
    }
}
