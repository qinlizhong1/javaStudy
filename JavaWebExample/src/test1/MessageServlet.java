package test1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", value = "/message")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        /**
         * 普通的getParameter不具备处理脏词的特性
         * 我们需要使用getParameter方法获取处理后的参数（使用过滤器处理脏词之后的参数）
         */
        String message = request.getParameter("message");
        response.getWriter().println(message);

        //控制台查看过滤后的情况
        System.out.println(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
