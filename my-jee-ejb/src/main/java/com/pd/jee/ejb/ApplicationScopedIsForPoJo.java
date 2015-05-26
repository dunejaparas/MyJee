package com.pd.jee.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;

import com.pd.jee.jar.SysoutPrintUtils;

@ApplicationScoped
public class ApplicationScopedIsForPoJo {
    // This class is constructed just once for the lifetime of started instance

    
    Logger logger = Logger.getLogger(this.getClass().getName());

    {
	logger.debug("--------		ApplicationScopedIsForPoJo");
    }

    private static final String POST_CONSTRUCT_AFTER_CREATE_APPLICATION_SCOPED = "\n'@PostConstruct afterCreate' ApplicationScopedIsForPoJo	SOUP >>>>>>>";
    private static final String PRE_DESTROY_AT_SHUTDOWN_APPLICATION_SCOPED = "'@PreDestroy atShutdown' ApplicationScopedIsForPoJo	SOUP >>>>>>>\n";

    private String name = "Soup of the day";

    @PostConstruct
    public void afterCreate() {
	// Called just Once
	SysoutPrintUtils
		.printSysout(POST_CONSTRUCT_AFTER_CREATE_APPLICATION_SCOPED);
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
	SysoutPrintUtils.printSysout("	######	Class FINALIZE method	######");
	super.finalize();
    }

    @PreDestroy
    void atShutdown() {
	SysoutPrintUtils
		.printSysout(PRE_DESTROY_AT_SHUTDOWN_APPLICATION_SCOPED);
    }

}
