package com.ericsson.oss.services.pm.initiation.ejb;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.pd.jee.api.FirstEjbServiceLocal;
 
import static com.pd.jee.jar.RandomStringGenerator.createRandomString;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(FirstEjbServiceLocal.class)
public class FirstEjbServiceImpl implements FirstEjbServiceLocal {


	@Override
	public List<String> listAddresses() {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(createRandomString(5));
		return arrayList;
	}

	@Override
	public String findSubscriberIdByName(String subscriberName) {
		return "No filtering done : " + createRandomString(5);
	}

}
