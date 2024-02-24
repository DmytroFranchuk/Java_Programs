package org.example.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.Logger;

public class LogFilter implements Filter {

    private final Logger logger = Logger.getLogger("HelloLogger");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Hello from: " + request.getLocalAddr());
        chain.doFilter(request, response);
    }
}
