package webapps.ROOT;

import stardard.HttpServlet;
import stardard.HttpServletRequest;
import stardard.HttpServletResponse;
import tomcat.HttpServletRequestImpl;
import tomcat.HttpServletResponseImpl;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // TODO: 验证用户名密码是否正确
        // TODO: 设置 Session 信息

        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("登录成功");
    }
}
