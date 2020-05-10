package com.lyy;

import java.io.IOException;

public class NotFoundServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        print404(req, resp);
    }



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        print404(req,resp);
    }

    private void print404(HttpServletRequest req, HttpServletResponse resp) {
    }
}
