package com.pd.jee.ejb;

import static com.pd.jee.jar.RandomStringGenerator.createRandomString;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.pd.jee.api.FirstEjbServiceLocal;
import com.pd.jee.api.SecondEjbServiceLocal;
import com.pd.jee.ejb.validator.SimpleBean;
import com.pd.jee.jar.SysoutPrintUtils;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
// @ApplicationScoped or @RequestScoped not allowed on @Stateless.
// Only @Dependent is allowed on stateless enterprise beans.
@Dependent
public class FirstEjbServiceImpl implements FirstEjbServiceLocal {

    @EJB
    SecondEjbServiceLocal dummyInjectUsage;

    @Inject
    SimpleBean helloBeanWithInterceptor;

    @PostConstruct
    public void afterCreate() {
	// Called just Once
	SysoutPrintUtils
		.printSysout("'@PostConstruct afterCreate' FirstEjbServiceImpl");
    }

    @Override
    public List<String> listAddresses() {
	final ArrayList<String> arrayList = new ArrayList<String>();
	arrayList.add(createRandomString(5));
	return arrayList;
    }

    @Override
    public String findSubscriberIdByName(final String subscriberName) {
	dummyInjectUsage.printSomethingToConsole("Injected using @EJB..."
		+ subscriberName);
	helloBeanWithInterceptor.setName(subscriberName);
	helloBeanWithInterceptor.setAddress("Subscriber Address");
	return "No filtering done : " + createRandomString(5);
    }

}
