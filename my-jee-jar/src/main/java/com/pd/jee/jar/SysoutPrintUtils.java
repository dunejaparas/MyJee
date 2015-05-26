package com.pd.jee.jar;

import org.apache.log4j.Logger;

public class SysoutPrintUtils {

    private static Logger logger = Logger.getLogger(SysoutPrintUtils.class
	    .getName());

    public static void printSysout(final String message) {
	logger.debug(String.format("%s", message));
    }

}
