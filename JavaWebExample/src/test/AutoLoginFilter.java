package test;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "AutoLoginFilter", value = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //获取请求路径
        String requestURI = request.getRequestURI();
        //判断请求路径是否与登录资源相关
        if (requestURI.contains("login")) {
            //请求是与登录相关资源
            chain.doFilter(request, resp);
        } else {
            /**
             * 请求的不是与登录的相关资源
             */
            User user = (User) request.getSession().getAttribute("user");
            /**
             * 判断登录状态
             */
            if (user == null) {
                Cookie cookie = CookieUtils.getCookie(request.getCookies(), "autoLogin");
                //cookie为空（被清理的缓存）
                if (cookie == null) {
                    //cookie被清理了，自动登录失败，请求转发至登录页面
                    request.getRequestDispatcher("/login.html").forward(request, resp);
                } else {
                    //有cookie进行自动登录操作
                    //获取账号信息，拼接好的字符串ziph-123456b，并进行拆分
                    String cookieValue = cookie.getValue();
                    String[] split = cookieValue.split("-");
                    String username = split[0];
                    String password = split[1];
                    if ("ziph".equals(username) && "123456".equals(password)) {
                        //自动登录成功，修改登陆状态，直接放行
                        user = new User();
                        user.setUsername(username);
                        user.setPassword(password);
                        request.getSession().setAttribute("user", user);
                        chain.doFilter(request, resp);
                    } else {
                        //自动登陆失败（修改了密码），转发至登录页面
                        request.getRequestDispatcher("/login.html").forward(request, resp);
                    }
                }
            } else {
                //在登录状态直接放行
                chain.doFilter(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
