package Controller;

import Dao.UserDao;
import Models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

@WebServlet (urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editUser":
                editUser(req, resp);
                break;
//                case "search":
//                    searchByName(request, response);
//                    break;
                case "logout":
                    logout(req, resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "editUser":
                    showEditFormUser(req, resp);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditFormUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingStudent = userDao.findUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userView/editP.jsp");
        request.setAttribute("user", existingStudent);
        dispatcher.forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int iduser = Integer.parseInt(request.getParameter("id"));
        String tk = request.getParameter("tk");
        String mk = request.getParameter("mk");
        String chucvu = request.getParameter("chucvu");
        String sdt = request.getParameter("sdt");
        String ten = request.getParameter("ten");
        String gioitinh = request.getParameter("gioitinh");
        String diachi = request.getParameter("diachi");

        User user = new User(iduser, tk, mk, chucvu, sdt, ten, gioitinh, diachi);
        userDao.edit(iduser, user);
        response.sendRedirect("/menu.jsp");
    }

    private void logout(HttpServletRequest request, HttpServletResponse response){

    }
}
