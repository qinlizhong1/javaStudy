package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/lg")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        /**
         * 1.获取请求参数账号和密码
         * 2.对帐号和密码进行校验（成功，则判断是否获取的到自动登录参数，是的话讲账号、密码存储在Cookie中）
         * 3.封装成对象存储在Session中
         * 4.转发至展示页面
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("qin".equals(username) && "123456".equals(password)) {
            String autoLogin = request.getParameter("autoLogin");
            if ("autoLogin".equals(autoLogin)) {
                Cookie cookie = new Cookie("autoLogin", username + "-" + password);
                cookie.setMaxAge(60 * 3);
                response.addCookie(cookie);
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/show").forward(request, response);
        } else {
            /**
             * 登录失败转发至登录页面
             */
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
