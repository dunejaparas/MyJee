package com.pd.jee.ejb.validator.annotations;

import java.lang.annotation.*;

import javax.interceptor.InterceptorBinding;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface ClassValidationInterceptorBinding {

}