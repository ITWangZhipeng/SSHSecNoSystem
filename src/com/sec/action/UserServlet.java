package com.sec.action;

import com.sec.DAO.IUserDao;
import com.sec.DAO.Impl.IUserDaoImpl;
import com.sec.db.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 10433208 on 2016/12/9.
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    public UserServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String value = null;
        value = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String password = request.getParameter("password");
        request.getSession().setAttribute("User", request.getParameter("username"));
        User user1 = new User();
        user1.setUserName(value);
        System.out.println(value);
        user1.setPassword(password);

        try {
            System.out.println("*******************");
            IUserDao userDao = new IUserDaoImpl();
            boolean loginCheck = userDao.loginValidate(user1);
            System.out.println("*******************");
            System.out.println(loginCheck);
            if (loginCheck) {
                response.getWriter().append("Login Success");
                response.getWriter().append("username: " + username
                        + "  password: " + password);
            } else {
                response.getWriter().append("Wrong Username or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
