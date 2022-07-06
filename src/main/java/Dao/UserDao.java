package Dao;

import Connect.ConnectMySql;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    String sql = "select * from user where tk = ? and mk =?";

    public User getUser (String user, String pass){
        try (Connection connection = ConnectMySql.getConnect()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user);
            statement.setString(2,pass);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("iduser");
            String tk = resultSet.getString("tk");
            String mk = resultSet.getString("mk");
            String chucvu = resultSet.getString("chucvu");
            String sdt = resultSet.getString("sdt");
            String ten = resultSet.getString("ten");
            String gioitinh = resultSet.getString("gioitinh");
            String diachi = resultSet.getString("diachi");

            return new User(id,tk,mk,chucvu,sdt,ten,gioitinh,diachi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
