package com.pd.jee.ejb;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

@Singleton
@Startup
@ApplicationScoped
/**
 @Stateless 	ERROR	- A component named 'MySingletonSLSB' is already defined in this module

 @RequestScoped ERROR	- RequestScoped is not allowed on singleton enterprise beans 
 Only @Dependent and @ApplicationScoped is allowed on singleton session beans.
 */
public class SingletonSLSB {

    public String requestSingletonSLSB() {
	// dummyUsage.findSubscriberIdByName("requestWhatTheOtherGuyHad");
	return "requestSingletonSLSB";
    }
}