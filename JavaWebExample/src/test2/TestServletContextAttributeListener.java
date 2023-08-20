package test2;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听ServletContext域中的属性变更
 */
//@WebListener
public class TestServletContextAttributeListener implements ServletContextAttributeListener {
    /**
     * 监听ServletContext域对象中属性的添加
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext Added");
    }

    /**
     * 监听ServletContext域对象中属性的移除
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext Removed");
    }

    /**
     * 监听ServletContext域对象中属性的替换
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext Replaced");
    }
}
