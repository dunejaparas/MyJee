package com.pd.jee.api;

import javax.ejb.Local;

@Local(SecondEjbServiceLocal.class)
public interface SecondEjbServiceLocal {
    void printSomethingToConsole(String subscriberName);
}
