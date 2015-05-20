package com.pd.jee.ejb;

import javax.ejb.*;

import com.pd.jee.api.SecondEjbServiceLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SecondEjbServiceImpl implements SecondEjbServiceLocal {

    @Override
    public void printSomethingToConsole(final String subscriberName) {
	System.out.println("printSomethingToConsole: " + subscriberName);
    }

}
