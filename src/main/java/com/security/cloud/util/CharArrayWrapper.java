package com.security.cloud.util;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharArrayWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter charWriter;

    /**
     * ��װ����ʼ��
     * <P>
     * ���������װ�������ø���Ĺ��췽������������Щ������setHeader, setStatus, addCookie��
     * <P>
     * ���⽫�½���һ���ַ��������ִ��response����Ӧ�������.
     */
    public CharArrayWrapper(HttpServletResponse response) {
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
