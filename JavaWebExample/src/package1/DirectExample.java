package package1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/direct")
public class DirectExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("-----------------------------------direct-----------------------------------");

        System.out.println("request.getContextPath()---->" + request.getContextPath());
        System.out.println("\nrequest.getRequestURI()---->" + request.getRequestURI());
        System.out.println("\nrequest.getRequestURL()---->" + request.getRequestURL());
        System.out.println("\nrequest.getServletPath()---->" + request.getServletPath());
        System.out.println("\nrequest.getServerName()---->" + request.getServerName());
        System.out.println("\nrequest.getServerPort()---->" + request.getServerPort());
        System.out.println("\nrequest.getProtocol()()---->" + request.getProtocol());

        //可以从上个servlet继承过来
        System.out.println("\nrequest param:");
        Enumeration<String> enumerationRequestParams = request.getParameterNames();
        while (enumerationRequestParams.hasMoreElements()){
            String key = enumerationRequestParams.nextElement();
            System.out.println(key + ":" + request.getParameter(key));
        }

        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("\nservletConfig.getServletName()---->" + servletConfig.getServletName());
        System.out.println("\ninit param:");
        Enumeration<String> enumerationInitParams = servletConfig.getInitParameterNames();
        while (enumerationInitParams.hasMoreElements()){
            String key = enumerationInitParams.nextElement();
            System.out.println(key + ":" + servletConfig.getInitParameter(key));
        }

        ServletContext servletContext = this.getServletContext();
        System.out.println("\nservletContext.getContextPath()---->" + servletContext.getContextPath());

        //可以从上个servlet继承过来
        System.out.println("\ncontext param:");
        Enumeration<String> enumerationContextParams = servletContext.getInitParameterNames();
        while (enumerationContextParams.hasMoreElements()){
            String key = enumerationContextParams.nextElement();
            System.out.println(key + ":" + servletContext.getInitParameter(key));
        }

        System.out.println("\ncookie:");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }

        System.out.println("\nsession:");
        HttpSession httpSession = request.getSession();
        Enumeration<String> enumerationHttpSession = httpSession.getAttributeNames();
        while (enumerationHttpSession.hasMoreElements()){
            String key = enumerationHttpSession.nextElement();
            System.out.println(key + ":" + httpSession.getAttribute(key));
        }

        System.out.println("\nheader:");
        Enumeration<String> enumerationHeaders = request.getHeaderNames();
        while (enumerationHeaders.hasMoreElements()){
            String key = enumerationHeaders.nextElement();
            System.out.println(key + ":" + request.getHeader(key));
        }

        System.out.println("\nrequest.getAttribute(\"requestAttributeKey\")--->" + request.getAttribute("requestAttributeKey"));
        System.out.println("\nservletContext.getAttribute(\"servletContextAttributeKey\")--->" + servletContext.getAttribute("servletContextAttributeKey"));
        System.out.println("\nhttpSession.getAttribute(\"httpSessionAttributeKey\")--->" + httpSession.getAttribute("httpSessionAttributeKey"));

        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        printWriter.println("中国人");

    }
}
