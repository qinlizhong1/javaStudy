package test2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        /**
         * 监听ServletContext域的初始化,随着服务器的启动
         */
        System.out.println("ServletContext初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //监听ServletContext域的销毁，随着服务器的关闭
        System.out.println("ServletContext销毁");
    }
}
