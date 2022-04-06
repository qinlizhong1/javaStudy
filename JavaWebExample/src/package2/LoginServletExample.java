package package2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login", initParams = {@WebInitParam(name="name", value = "admin"), @WebInitParam(name = "passwd", value = "123456")})
public class LoginServletExample extends HttpServlet {
    private String initUserName = null;
    private String initPassWord = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");

        if (userName.equals(initUserName) && passWord.equals(initPassWord)){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("name", userName);

            req.getRequestDispatcher("/example1/welcome.jsp").forward(req, resp);
        }else {//重定向
            System.out.println("账号或密码错误");
            resp.sendRedirect("/JavaWebExample_war_exploded/example1/login.jsp");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        initUserName = config.getInitParameter("name");
        initPassWord  = config.getInitParameter("passwd");
    }
}
