package org.example.filter;

import jakarta.servlet.*;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.logging.Logger;
@Log4j2
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("Hello from: " + request.getLocalAddr());
        chain.doFilter(request, response);
    }
}
