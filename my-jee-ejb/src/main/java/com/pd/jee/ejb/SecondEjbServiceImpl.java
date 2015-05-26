package com.pd.jee.ejb;

import javax.ejb.*;

import org.apache.log4j.Logger;

import com.pd.jee.api.SecondEjbServiceLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SecondEjbServiceImpl implements SecondEjbServiceLocal {

    Logger logger = Logger.getLogger(this.getClass().getName());

    
    @Override
    public void printSomethingToConsole(final String subscriberName) {
	logger.debug("printSomethingToConsole: " + subscriberName);
    }

}
