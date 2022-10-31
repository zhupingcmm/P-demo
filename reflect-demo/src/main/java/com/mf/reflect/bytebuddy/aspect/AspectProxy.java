package com.mf.reflect.bytebuddy.aspect;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class AspectProxy {

    private IAspect iAspect;

    public void setiAspect(IAspect iAspect) {
        this.iAspect = iAspect;
    }


    @RuntimeType
    @BindingPriority(value = 1)
    public Object intercept (@This Object obj, @AllArguments Object[] allArguments, @SuperCall Callable<?> zuper,
                             @Origin Method method) throws Throwable {


        Object ret = null;
        ThreadLocal<String> a = new ThreadLocal<>();

        a.set("a");

        iAspect.beforeMethod(obj, method, allArguments, ret);
        try {
            if (ret == null) {
                ret = zuper.call();
            }
        } catch (Throwable t) {
            try {
                iAspect.handleMethodException(obj, method, allArguments, t);
            } catch (Throwable t1) {

            }
        } finally {
            try {
                iAspect.afterMethod(obj, method, allArguments, ret);
            } catch (Throwable t3) {
                String info = String.format("class[%s] afterMethod method[%s] intercept failure", obj.getClass(), method.getName());

            }
        }

        return ret;
    }
}
