package com.pd.jee.ejb.validator;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.pd.jee.ejb.validator.annotations.ClassValidationInterceptorBinding;
import com.pd.jee.ejb.validator.annotations.ValidateSomeData;

@Stateless
@ClassValidationInterceptorBinding
public class SimpleBean {

    protected String name;

    public String getName() {
	return name;
    }

    @Interceptors(BasicMethodInterceptor.class)
    public void setName(final String name) {
	this.name = name;
    }

    @ValidateSomeData
    public void setAddress(final String name) {
	this.name = name;
    }

}
