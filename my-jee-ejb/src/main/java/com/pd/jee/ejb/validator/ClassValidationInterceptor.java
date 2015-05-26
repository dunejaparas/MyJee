package com.pd.jee.ejb.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.interceptor.*;

import org.apache.log4j.Logger;

import com.pd.jee.ejb.validator.annotations.ClassValidationInterceptorBinding;
import com.pd.jee.ejb.validator.annotations.ValidateSomeData;

@ClassValidationInterceptorBinding
@Interceptor
public class ClassValidationInterceptor {

    // @Inject
    // private SubscriptionValidationUtil validationUtil;
    Logger logger = Logger.getLogger(this.getClass().getName());

    
    @AroundInvoke
    public Object validate(final InvocationContext ctx) throws Exception { // NOPMD
	logger.debug(">>> ClassValidationInterceptor >>>");
	Object result = null;

	final Method method = ctx.getMethod();
	if (method.isAnnotationPresent(ValidateSomeData.class)) {
	    final String outPutString = ">>>>>>>>>>>>	Found class Validation annotation @ValidateSomeData	<<<<<<<<<<<<<<<<<<<<<<<<<";
	    logger.debug(outPutString);

	} else {
	    logger.debug("carry on ");
	}

	final Annotation[] annotations = method.getAnnotations();
	for (final Annotation currentAnnotation : annotations) {
	    logger.debug("currentAnnotation:Name "
		    + currentAnnotation.getClass().getName());
	}

	/*
	 * // We create various annotations and see which annotation is there to
	 * // identify what to validate if
	 * (method.isAnnotationPresent(ValidateSubscriptionData.class)) {
	 * 
	 * final Object[] parameters = ctx.getParameters();
	 * 
	 * Object firstParameter = null;
	 * 
	 * // At the moment we have only one parameter for all the api's and //
	 * hence we are considering validation only for the first // parameter
	 * of the methods in the // SubscriptionPersistenceServiceImpl
	 * 
	 * if (parameters.length > 0 && parameters[0] != null) { firstParameter
	 * = parameters[0];
	 * 
	 * } else { // the first parameter is null or there are no parameters,
	 * // validation should not be handled. return ctx.proceed(); }
	 * 
	 * doGenericValidation(firstParameter); }
	 */
	result = ctx.proceed();
	logger.debug("<<< ClassValidationInterceptor <<<");
	return result;
    }

    // private void doGenericValidation(final Object parameters)
    // throws PMICInvalidInputException {
    //
    // if (parameters instanceof Subscription) {
    // validationUtil.validateSubscription((Subscription) parameters);
    // }
    // }
}