package test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 注意：销毁和移除都能触发监听器的attributeRemoved方法
 */
@WebServlet(name = "TestSessionAttributeServlet", value = "/tsas")
public class TestSessionAttributeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StringBuffer buffer = new StringBuffer();
        buffer.append("ziph");
        //添加
        session.setAttribute("name", buffer);
        buffer.append(" is very good!");
        //替换
        session.setAttribute("name", buffer);
        //移除
        session.removeAttribute("name");
        //销毁
        session.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

