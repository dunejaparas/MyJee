package com.pd.jee.common;

import javax.inject.Inject;

import org.apache.log4j.Logger;

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

    Logger logger = Logger.getLogger(this.getClass().getName());

    private static int count = 0;

    public String createHelloMessage(final String name) {

	final String data = ejbServiceLocal.findSubscriberIdByName(name);

	System.out.println("Count :" + count);
	System.out.println(System.getProperty("user.dir"));
	if (count % 5 == 0) {
	    type.orderWhatTheOtherGuyHad();
	    logger.debug(":::::::::::::::orderWhatTheOtherGuyHad : " + data);
	} else if (count % 2 == 0) {
	    slsb.requestSingletonSLSB();
	    logger.debug(">>>>>>>>>>>>>>>requestSingletonSLSB : " + data);
	} else {
	    type.requestWhatTheOtherGuyHad();
	    logger.debug("+++++++++++++++requestWhatTheOtherGuyHad : " + data);
	}
	count++;
	return "Hello " + name + "!";
    }

}
