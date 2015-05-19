package com.pd.jee.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class WaiterSLSB {

    @Inject
    public ApplicationScopedIsForPoJo soup;

    @Inject
    public RequestScopedIsForPoJo requestSoup;

    //
    // @EJB
    // FirstEjbServiceImpl dummyUsage;

    public String orderSoup(final String name) {
	soup.setName(name);
	return soup.getName();
    }

    public String orderWhatTheOtherGuyHad() {
	final String name = soup.getName();
	// dummyUsage.findSubscriberIdByName("orderWhatTheOtherGuyHad");
	return name;
    }

    public String requestWhatTheOtherGuyHad() {
	final String name = requestSoup.getName();
	// dummyUsage.findSubscriberIdByName("requestWhatTheOtherGuyHad");
	return name;
    }
}