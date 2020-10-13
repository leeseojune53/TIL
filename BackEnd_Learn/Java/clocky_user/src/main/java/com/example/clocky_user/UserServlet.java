package com.example.clocky_user;

import com.example.clocky_user.model.UserDAO;
import com.example.clocky_user.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            request.setCharacterEncoding("utf-8");

            UserVO vo = new UserVO();
            vo.setName(request.getParameter("name"));
            vo.setPassword(Integer.parseInt(request.getParameter("password")));

            UserDAO dao = new UserDAO();
            dao.insert(vo);

            response.sendRedirect("/daovo/form.jsp");
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}