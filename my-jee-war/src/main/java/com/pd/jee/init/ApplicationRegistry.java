
package com.pd.jee.init;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.as.quickstarts.rshelloworld.HelloWorld;
import org.jboss.as.quickstarts.rshelloworld.resources.CounterRestResource;

import com.pd.jee.bookstore.BookStoreResource;
import com.pd.jee.irish.pubs.IrishPubs;

public class ApplicationRegistry extends Application {
    private final Set<Object> resourceObjects = new HashSet<Object>();
    private final Set<Class<?>> resourceClasses = new HashSet<Class<?>>();

    public ApplicationRegistry() {
	resourceClasses.add(CounterRestResource.class);
	resourceClasses.add(HelloWorld.class);
	resourceClasses.add(IrishPubs.class);
	resourceClasses.add(BookStoreResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
	return resourceClasses;
    }

    @Override
    public Set<Object> getSingletons() {
	return resourceObjects;
    }
}
