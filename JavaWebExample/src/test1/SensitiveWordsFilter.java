package test1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 脏词：扯淡、笨蛋、王八蛋
 */
public class SensitiveWordsFilter implements Filter {
    //存放脏词的集合
    List<String> sensitiveWords = new ArrayList<>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //增强getParameter方法（增加过滤功能）
        HttpServletRequest requestProxy = (HttpServletRequest) Proxy.newProxyInstance(
                request.getClass().getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValues = null;
                        String methodName = method.getName();
                        if ("getParameter".equals(methodName)) {
                            String returnValues1 = (String) method.invoke(request, args);
                            //开始处理脏词
                            for (String sensitiveWord : sensitiveWords) {
                                if (returnValues1.contains(sensitiveWord)) {
                                    /**
                                     * getParameter方法返回值中有脏词
                                     * 可以根据脏词长度返回*号个数
                                     */
                                    StringBuffer buffer = new StringBuffer();
                                    for (int i = 0; i < sensitiveWord.length(); i++) {
                                        buffer.append("*");
                                    }
                                    returnValues1 = returnValues1.replace(sensitiveWord, buffer);
                                }
                            }
                            return returnValues1;
                        }
                        else {
                            returnValues = method.invoke(request, args);
                        }
                        return returnValues;
                    }
                });
        /**
         * 放行增强的request对象——requestProxy
         */
        chain.doFilter(requestProxy, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        /**
         * 获取所有初始化参数（脏词）
         */
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String sensitiveWord = config.getInitParameter(initParameterNames.nextElement());
            //把所有脏词加入集合中
            sensitiveWords.add(sensitiveWord);
        }
    }
}
