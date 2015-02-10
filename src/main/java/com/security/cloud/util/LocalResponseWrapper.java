package com.security.cloud.util;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Only for writer, no for outputstream type
 * 
 * @version $Rev$ $Date$
 */
public class LocalResponseWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter charWriter;

    public LocalResponseWrapper(HttpServletResponse response) {
        super(response);
        charWriter = new CharArrayWriter();
    }

    public PrintWriter getWriter() {
        return new PrintWriter(charWriter);
    }

    public String toString() {
        return charWriter.toString();
    }

    public char[] toCharArray() {
        return charWriter.toCharArray();
    }
}
