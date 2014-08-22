package com.itsci.utility;

import javax.servlet.ServletContext;

public class ServletUtils {
	private static final String REPORTS_PATH = "/WEB-INF/ireport/";
	
	public static String getReportFile(ServletContext sc, String name) {
		String result = "";
		if (sc != null) {
			result  = sc.getRealPath(REPORTS_PATH + name);
		}
		return result;
	}
}