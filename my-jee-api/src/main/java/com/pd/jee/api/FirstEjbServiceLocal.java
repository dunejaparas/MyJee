package com.pd.jee.api;

import java.util.List;

public interface FirstEjbServiceLocal {


	List<String> listAddresses();
    String findSubscriberIdByName(String subscriberName);
}
