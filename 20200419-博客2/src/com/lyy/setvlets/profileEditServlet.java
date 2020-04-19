package com.lyy.setvlets;


import com.lyy.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile/edit")
public class profileEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nickname = req.getParameter("nickname");
        String brief = req.getParameter("brief");
        //TODO:合法性校验

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            resp.sendError(401);
            return;
        }
        //要修改用户，但修改那个用户的资料？
        //HTTP的无状态性，导致不知道修改那个用户的信息

        //通过登录状态获取
        try {
            User.update(user.id,nickname,brief);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new ServletException(e);
        }
        user.nickname = nickname;
        user.brief = brief;
        session.setAttribute("user",user);
        resp.sendRedirect("/u");
    }
}
