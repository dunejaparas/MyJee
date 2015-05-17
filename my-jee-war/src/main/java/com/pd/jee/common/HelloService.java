package com.pd.jee.common;

import javax.inject.Inject;

import com.pd.jee.api.FirstEjbServiceLocal;

public class HelloService {

	@Inject
	FirstEjbServiceLocal ejbServiceLocal;

	
	public String createHelloMessage(final String name) {

		String data =  ejbServiceLocal.findSubscriberIdByName(name);
		System.out.println("My first EJB log : " + data);
		return "Hello " + name + "!";
	}

}
