package com.security.cloud.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.security.cloud.util.LocalResponseWrapper;

public class MyFilter implements Filter {
    
    private static final String LOG_MESSAGE_PREAMBLE = "MyFilter: LogInfo: ";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // NOOP
    }

    @Override
    public void destroy() {
        // NOOP
    }

    /**
     * Check for the broken MS WebDAV client and if detected issue a re-direct
     * that hopefully will cause the non-broken client to be used.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) ||
                !(response instanceof HttpServletResponse)) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        HttpServletResponse httpResponse = ((HttpServletResponse) response);
        LocalResponseWrapper wrapper = new LocalResponseWrapper(httpResponse); 

        // Pass control on to the next filter
        //chain.doFilter(request, response);
        chain.doFilter(request, wrapper);
        String result = wrapper.toString();
        log(request, result);
        
//        httpResponse.getOutputStream()
        try {
            PrintWriter out = httpResponse.getWriter();
            out.write(result);
            out.close(); 
        } catch (IllegalStateException e) {
//            OutputStream out = response.getOutputStream();
        }
    }
    private void log(ServletRequest request, String msg) {
        StringBuilder builder = new StringBuilder(LOG_MESSAGE_PREAMBLE);
        builder.append(msg);
        request.getServletContext().log(builder.toString());
    }
}