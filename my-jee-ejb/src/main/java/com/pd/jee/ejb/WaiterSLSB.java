package com.pd.jee.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class WaiterSLSB {

    /**
     * NO 'META-INF\beans.xml' (even if empty). no CDI
     */
    @Inject
    public ApplicationScopedIsForPoJo soup;

    // NO 'META-INF\beans.xml' (even if empty). no CDI
    @Inject
    public RequestScopedIsForPoJo requestSoup;

    public String orderSoup(final String name) {
	soup.setName(name);
	return soup.getName();
    }

    public String orderWhatTheOtherGuyHad() {
	final String name = soup.getName();
	return name;
    }

    public String requestWhatTheOtherGuyHad() {
	final String name = requestSoup.getName();
	return name;
    }
}