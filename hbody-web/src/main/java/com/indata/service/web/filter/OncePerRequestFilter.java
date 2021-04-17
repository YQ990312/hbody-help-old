/*
 *
 *  * Copyright 2020 byai.com All right reserved. This software is the
 *  * confidential and proprietary information of byai.com ("Confidential
 *  * Information"). You shall not disclose such Confidential Information and shall
 *  * use it only in accordance with the terms of the license agreement you entered
 *  * into with byai.com.
 *
 */

package com.indata.service.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract class OncePerRequestFilter implements Filter {
    private String alreadyFilteredAttributeName = this.getClass().getName().concat(".FILTERED");

    public OncePerRequestFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            boolean hasAlreadyFilteredAttribute = request.getAttribute(this.alreadyFilteredAttributeName) != null;
            if (hasAlreadyFilteredAttribute) {
                filterChain.doFilter(request, response);
            } else {
                request.setAttribute(this.alreadyFilteredAttributeName, Boolean.TRUE);

                try {
                    this.doFilterInternal(httpRequest, httpResponse, filterChain);
                } finally {
                    request.removeAttribute(this.alreadyFilteredAttributeName);
                }
            }

        } else {
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");
        }
    }

    protected abstract void doFilterInternal(HttpServletRequest var1, HttpServletResponse var2, FilterChain var3) throws ServletException, IOException;


}
