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
import java.util.List;

@WebServlet(urlPatterns = "/selUser")
public class searchUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search_name = req.getParameter("selName");
        String search_sex = req.getParameter("selSex");
        String search_bir = req.getParameter("selBir");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date = null;
        try {
            date = (Date)sdf.parse(search_bir);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserService userService = new UserService();
        List<User> list = userService.searchUser(search_name,search_sex,date);
        req.setAttribute("users", list);
        req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
    }
}
