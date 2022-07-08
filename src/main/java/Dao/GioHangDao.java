package Dao;

import Connect.ConnectMySql;
import Models.GioHang;
import Models.Sanpham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GioHangDao implements CRUD<GioHang> {
    @Override
    public List<GioHang> getAll() {
        return null;
    }

    @Override
    public boolean create(GioHang gioHang) {
        return false;
    }

    @Override
    public boolean edit(int id, GioHang gioHang) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public GioHang findById(int id) {
        GioHang gioHang = null;
        try (Connection connection = ConnectMySql.getConnect()
        ) { String sql = "select idsp, tensp, gia from sanpham where idsp =?";
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                rs.next();
                    int idsp = Integer.parseInt(rs.getString("idsp"));
                    String tensp = rs.getString("tensp");
                    float gia = Float.parseFloat(rs.getString("gia"));
                    gioHang = new GioHang(idsp,tensp,gia, 1);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return gioHang;
    }

    public boolean createHoaDon(Date ngxuathd, int iduser) {
        boolean check = false;
        try (Connection connection = ConnectMySql.getConnect()
        ) { String sql = "insert into hoadon (ngxuathd,iduser,trigia) values (?,?,0);";
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, ngxuathd);
                preparedStatement.setInt(2, iduser);
                System.out.println(preparedStatement);
                check = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return check;
    }

    public int catchIdhd(Date ngxuathd, int iduser) {
        int idhd = -1;
        try (Connection connection = ConnectMySql.getConnect()
        ) { String sql = "select idhd from hoadon where ngxuathd=? and iduser=? and trigia=0;";
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, ngxuathd);
                preparedStatement.setInt(2, iduser);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                rs.next();
                idhd = Integer.parseInt(rs.getString("idhd"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return idhd;
    }

    public float catchTrigia(int idhd) {
        float trigia = 0;
        try (Connection connection = ConnectMySql.getConnect()
        ) { String sql = "select trigia from hoadon where idhd = ?;";
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idhd);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                rs.next();
                trigia = Float.parseFloat(rs.getString("trigia"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return trigia;
    }

    public boolean createCTHD(int idhd, int idsp, int sl) {
        boolean check = false;
        try (Connection connection = ConnectMySql.getConnect()
        ) { String sql = "insert into cthd (idhd,idsp,sl) values (?,?,?)";
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idhd);
                preparedStatement.setInt(2, idsp);
                preparedStatement.setInt(3, sl);
                System.out.println(preparedStatement);
                check = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return check;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace();
                System.out.println("SQLState:" + ((SQLException) e).getSQLState());
                System.out.println("Error Code:" + ((SQLException) e).getSQLState());
                System.out.println("Message:" + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
            }
        }
    }
}
