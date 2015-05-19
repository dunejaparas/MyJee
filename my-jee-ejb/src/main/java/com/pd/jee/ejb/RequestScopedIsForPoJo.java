package com.pd.jee.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

import com.pd.jee.jar.SysoutPrintUtils;

@RequestScoped
public class RequestScopedIsForPoJo {
    // This class is constructed and de-constructed for each request it caters
    // to
    {
	System.out.println("--------		RequestScopedIsForPoJo");
    }

    private static final String POST_CONSTRUCT_AFTER_CREATE_REQUEST_SCOPED = "'@PostConstruct afterCreate' RequestScopedIsForPoJo";
    private static final String PRE_DESTROY_AT_SHUTDOWN_REQUEST_SCOPED = "'@PreDestroy atShutdown' RequestScopedIsForPoJo";
    private String name = "REQUEST of the day";

    @PostConstruct
    public void afterCreate() {
	// Called just Once
	SysoutPrintUtils
		.printSysout(POST_CONSTRUCT_AFTER_CREATE_REQUEST_SCOPED);
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
	super.finalize();
    }

    @PreDestroy
    void atShutdown() {
	SysoutPrintUtils.printSysout(PRE_DESTROY_AT_SHUTDOWN_REQUEST_SCOPED);
    }
}
