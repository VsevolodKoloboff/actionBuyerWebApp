package ru.coloboff.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.coloboff.webapp.utils.DBUtils;
import ru.coloboff.webapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String code = (String) request.getParameter("code");

        String errorString = null;

        try {
            DBUtils.deleteProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
            request.setAttribute("errorString", errorString);

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}