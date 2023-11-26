package mk.ukim.finki.labb.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb.model.Book;

import java.io.IOException;
public class BookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        //User user=(User)request.getSession().getAttribute("user");
        Book book=(Book)request.getSession().getAttribute("book");

        String path=request.getServletPath();

            System.out.println("WebFilter preprocessing...");
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("WebFilter postprocessing...");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
