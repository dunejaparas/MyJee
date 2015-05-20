package com.pd.jee.ejb.validator;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class BasicMethodInterceptor {
    protected String greeting;

    public BasicMethodInterceptor() {
	System.out.println("interceptor.ejb.MethodInterceptor .CONSTRUCTOR");
    }

    @AroundInvoke
    public Object modifyGreeting(final InvocationContext ctx) throws Exception {
	final Object[] parameters = ctx.getParameters();
	String param = (String) parameters[0];
	System.out.println("BasicMethodInterceptor Param: " + param);
	param = param.toLowerCase();
	parameters[0] = param;
	ctx.setParameters(parameters);
	try {
	    return ctx.proceed();
	} catch (final Exception e) {
	    System.out.println("Error calling ctx.proceed in modifyGreeting()");
	    return null;
	}
    }

}
