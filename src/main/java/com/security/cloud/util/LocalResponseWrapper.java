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

    /**
     * ��װ����ʼ��
     * <P>
     * ���������װ�������ø���Ĺ��췽������������Щ������setHeader, setStatus, addCookie��
     * <P>
     * ���⽫�½���һ���ַ��������ִ��response����Ӧ�������.
     */
    public LocalResponseWrapper(HttpServletResponse response) {
        super(response);
        charWriter = new CharArrayWriter();
    }

    public PrintWriter getWriter() {
        return new PrintWriter(charWriter);
    }

    /**
     * �����������ַ�ת����һ���ַ�������.
     * <P>
     * ��Ҫע����ǲ�Ҫ��ͬһ����װ����ε��ø÷���������ÿ�η���һ���µ��ַ�����
     */
    public String toString() {
        return charWriter.toString();
    }

    public char[] toCharArray() {
        return charWriter.toCharArray();
    }
}
