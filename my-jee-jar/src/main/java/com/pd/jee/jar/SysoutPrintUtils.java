package com.pd.jee.jar;

public class SysoutPrintUtils {

    private static final String STRING = "******	                                        	******";

    public static void printSysout(final String message) {
	System.out.println(STRING);
	System.out.println(String.format("******	%s	******", message));
	System.out.println(STRING);
    }

}
