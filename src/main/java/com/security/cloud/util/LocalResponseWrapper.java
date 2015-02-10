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
     * 包装器初始化
     * <P>
     * 首先这个包装器将调用父类的构造方法，并设置这些方法如setHeader, setStatus, addCookie等
     * <P>
     * 另外将新建立一个字符输出流来执行response的响应输出操作.
     */
    public LocalResponseWrapper(HttpServletResponse response) {
        super(response);
        charWriter = new CharArrayWriter();
    }

    public PrintWriter getWriter() {
        return new PrintWriter(charWriter);
    }

    /**
     * 将缓冲区的字符转换成一个字符串返回.
     * <P>
     * 需要注意的是不要对同一个包装器多次调用该方法，否则将每次返回一个新的字符串！
     */
    public String toString() {
        return charWriter.toString();
    }

    public char[] toCharArray() {
        return charWriter.toCharArray();
    }
}
