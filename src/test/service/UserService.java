package test.service;

import test.entity.User;
import test.utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserService extends JDBCUtils {

    ResultSet rs = null;

    /*查询所有*/
    public List<User> findAll() {

        List<User> list = new ArrayList();
        String sql = "select * from user";
        rs = executeQuery(sql);
        try {
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*增*/
    public int addUser(User user) {
        int num = 0;
        String sql = "insert into user(name,birthday,sex,phone,occupation,remarks) values(?,?,?,?,?,?)";
        try {
            num = executeUpdate(sql, user.getName(), user.getBirthday(),
                    user.getSex(), user.getPhone(), user.getOccupation(), user.getRemarks());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    /*删*/
    public int DeleteUser(int id) {
        int num = 0;
        String sql = "delete from user where id = ?";
        try {
            num = executeUpdate(sql, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return num;
    }

    /*改*/
    public int UpdateUser(User user) {
        int num = 0;
        String sql = "update user set name = ?,birthday = ?,sex = ?,phone = ?,occupation = ?,remarks = ? where id = ?";
        try {
            num = executeUpdate(sql, user.getName(), user.getBirthday(), user.getSex(), user.getPhone(), user.getOccupation(), user.getRemarks(), user.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return num;
    }

    /*按id查*/
    public User getUserById(int id) {
        String sql = "select * from user where id = ?";
        User user = null;
        rs = executeQuery(sql, id);
        try {
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /*按名字+性别+出生日期查*/
    public List<User> searchUser(String name,String sex,Date date) {
        String sql = "select * from user where name like ? and sex like ? and birthday = ?";
        String name2 = "%"+name+"%";
        String name3 = "%"+sex+"%";
        List<User> users = new ArrayList<>();
        User user = null;
        rs = executeQuery(sql,name2,name3,date);
        try {
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
