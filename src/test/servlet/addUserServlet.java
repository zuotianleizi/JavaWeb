package test.servlet;


import test.entity.User;
import test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = "/addUser")
public class addUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String phone = req.getParameter("phone");
        String occupation = req.getParameter("occupation");
        String remarks =req.getParameter("remarks");
        String birthday = req.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date = null;
        try {
            date = (Date)sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(name,date,sex,phone,occupation,remarks);
        UserService userService = new UserService();
        userService.addUser(user);
        System.out.println("添加成功");
        resp.sendRedirect(req.getContextPath()+"/home");
    }

}


