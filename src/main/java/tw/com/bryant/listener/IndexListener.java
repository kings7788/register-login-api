package tw.com.bryant.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class IndexListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.warn("ServletContex初始化");
        log.warn(servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.warn("ServletContex销毁");
    }
}
