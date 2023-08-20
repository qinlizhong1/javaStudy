package test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServletRequestAttributeServlet", value = "/tsras")
public class TestServletRequestAttributeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ziph");
        //添加
        request.setAttribute("name", buffer);
        buffer.append("marry");
        //替换
        request.setAttribute("name", buffer);
        //移除
        request.removeAttribute("name");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

