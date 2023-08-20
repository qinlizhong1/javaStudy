package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowServlet", value = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        StringBuffer buffer = new StringBuffer();
        if (user == null) {
            buffer.append("对不起，您还没有登录！<br><a href='/javaWebExample_war_exploded/login.html'>请登录</a>");
        } else {
            buffer.append(user.getUsername() + " 主人，您回来啦！");
        }
        response.getWriter().println(buffer.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}