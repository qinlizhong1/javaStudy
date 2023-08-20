package test;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(value = {"/a", "/b"}, initParams = {@WebInitParam(name="k1", value="v1")})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /**
         * 解决获取浏览器Post请求后在控制台中解码后的乱码问题
         */
        request.setCharacterEncoding("utf-8");
        /**
         * 解决服务器响应浏览器后浏览器显示内容乱码问题
         */
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = requestParameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            //键 - 请求参数名称
            String parameterName = entry.getKey();
            //值 - 一组请求参数值
            String[] values = entry.getValue();
            StringBuffer buffer = new StringBuffer();
            for (String value : values) {
                buffer.append(value + " ");
            }
            System.out.println("参数名称 : " + parameterName + "参数值 : " + buffer);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
