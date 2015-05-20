package com.pd.jee.api;

import java.util.List;

import javax.ejb.Local;

@Local(FirstEjbServiceLocal.class)
public interface FirstEjbServiceLocal {

    List<String> listAddresses();

    String findSubscriberIdByName(String subscriberName);
}
