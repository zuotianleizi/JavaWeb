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

@WebServlet("/updateUser")
public class updateUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        UserService userService =   new UserService();
        User user = userService.getUserById(id);

        req.setAttribute("user",user);
        req.getRequestDispatcher("/user/update.jsp").forward(req,resp);

    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        UserService userService = new UserService();
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String sex = req.getParameter("sex");
            String phone = req.getParameter("phone");
            String occupation = req.getParameter("occupation");
            String remarks = req.getParameter("remarks");

            String birthday = req.getParameter("birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
            Date date = null;
            date = (Date) sdf.parse(birthday);

            User user = new User(id,name, date, sex, phone, occupation, remarks);
            userService.UpdateUser(user);
            resp.sendRedirect(req.getContextPath()+"/home");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

}
