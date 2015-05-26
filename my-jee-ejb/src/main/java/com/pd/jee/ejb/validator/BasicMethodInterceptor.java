package com.pd.jee.ejb.validator;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class BasicMethodInterceptor {

    Logger logger = Logger.getLogger(this.getClass().getName());

    protected String greeting;

    public BasicMethodInterceptor() {
	logger.debug("interceptor.ejb.MethodInterceptor .CONSTRUCTOR");
    }

    @AroundInvoke
    public Object modifyGreeting(final InvocationContext ctx) throws Exception {
	final Object[] parameters = ctx.getParameters();
	String param = (String) parameters[0];
	logger.debug("BasicMethodInterceptor Param: " + param);
	param = param.toLowerCase();
	parameters[0] = param;
	ctx.setParameters(parameters);
	try {
	    return ctx.proceed();
	} catch (final Exception e) {
	    logger.debug("Error calling ctx.proceed in modifyGreeting()");
	    return null;
	}
    }

}
