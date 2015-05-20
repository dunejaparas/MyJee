package com.pd.jee.common;

import javax.inject.Inject;

import com.pd.jee.api.FirstEjbServiceLocal;
import com.pd.jee.ejb.SingletonSLSB;
import com.pd.jee.ejb.WaiterSLSB;

public class HelloService {

    @Inject
    FirstEjbServiceLocal ejbServiceLocal;

    @Inject
    WaiterSLSB type;

    @Inject
    SingletonSLSB slsb;

    private static int count = 0;

    public String createHelloMessage(final String name) {

	final String data = ejbServiceLocal.findSubscriberIdByName(name);

	if (count++ % 2 == 0) {
	    type.orderWhatTheOtherGuyHad();
	    System.out.println(":::::::::::::::orderWhatTheOtherGuyHad : "
		    + data);
	} else if (count % 5 == 0) {
	    slsb.requestSingletonSLSB();
	    System.out.println(">>>>>>>>>>>>>>>requestSingletonSLSB : " + data);
	} else {
	    type.requestWhatTheOtherGuyHad();
	    System.out.println("+++++++++++++++requestWhatTheOtherGuyHad : "
		    + data);
	}
	return "Hello " + name + "!";
    }

}
