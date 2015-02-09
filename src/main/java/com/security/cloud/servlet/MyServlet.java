package com.security.cloud.servlet;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.servlets.WebdavServlet;

public class MyServlet extends WebdavServlet {
	private static final long serialVersionUID = 8296785274079983242L;
	
	private int maxDepth = 3;

	@Override
	protected String getRelativePath(HttpServletRequest request) {
		/**
		 * ¶ÔÓÚdefaultservlet return new
		 * String(getRelativePath(request).getbytes("iso-8859-1"),"utf-8");
		 */
		String path = super.getRelativePath(request);

		// try {
		// return new String(path.getBytes("utf-8"));
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }

		return path;
	}
}
