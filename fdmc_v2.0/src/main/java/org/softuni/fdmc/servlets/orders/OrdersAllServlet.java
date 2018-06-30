package org.softuni.fdmc.servlets.orders;

import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.models.UserRole;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/all")
public class OrdersAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getSession().getAttribute("username").toString();
        UserRepository userRepository = (UserRepository)this.getServletContext().getAttribute("users");
        User user = userRepository.getByUsername(username);

        if(user.getRole() != UserRole.ADMIN)
            resp.sendRedirect("/");
        else
            req.getRequestDispatcher("all.jsp").forward(req, resp);
    }
}
