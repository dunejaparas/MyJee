package com.pd.jee.common;

public class CreateJson {

    private static final String JSON = "{\"%s\":\"%s\"}";

    public static String getJsonResponse(final String key, final String value) {
	return String.format(JSON, key, value);
    }

}
