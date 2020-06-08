package tw.com.bryant.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@Order(1)
//重点
@WebFilter(filterName = "myfilter", urlPatterns = "/*")
public class IndexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.warn("================需要过滤器做什么？==================");
        if("2".equals(servletRequest.getParameter("id"))){
            servletResponse.getWriter().write("Cannot query the data！");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
