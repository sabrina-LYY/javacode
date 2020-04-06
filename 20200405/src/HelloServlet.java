import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当get请求时的处理逻辑
        String name = req.getParameter("name");//对get方法，就是从QueryString中获取
        if(name==null){
            name = "世界";
        }
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("<h1>GET</h1>");
        resp.getWriter().println("<p>你好"+name+"</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当post请求时的处理逻辑
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("<h1>POST</h1>");
        resp.getWriter().println("<p>你好世界</p>");

    }
}

