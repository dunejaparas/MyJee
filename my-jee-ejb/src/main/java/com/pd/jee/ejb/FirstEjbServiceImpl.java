package com.pd.jee.ejb;

import static com.pd.jee.jar.RandomStringGenerator.createRandomString;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.*;

import com.pd.jee.api.FirstEjbServiceLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(FirstEjbServiceLocal.class)
public class FirstEjbServiceImpl implements FirstEjbServiceLocal {

    @Override
    public List<String> listAddresses() {
	final ArrayList<String> arrayList = new ArrayList<String>();
	arrayList.add(createRandomString(5));
	return arrayList;
    }

    @Override
    public String findSubscriberIdByName(final String subscriberName) {
	return "No filtering done : " + createRandomString(5);
    }

}
