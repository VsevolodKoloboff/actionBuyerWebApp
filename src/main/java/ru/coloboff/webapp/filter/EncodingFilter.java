package ru.coloboff.webapp.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "encodingName", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

    public EncodingFilter(){

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request,response);

    }
}
