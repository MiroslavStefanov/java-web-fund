package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.OrderRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getQueryString().split("=")[1];

        Cat cat = ((CatRepository)this.getServletContext().getAttribute("cats")).getByName(catName);
        cat.incrementViews();

        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getQueryString().split("=")[1];
        String username = req.getSession().getAttribute("username").toString();

        Cat cat = ((CatRepository)this.getServletContext().getAttribute("cats")).getByName(catName);
        User user = ((UserRepository)this.getServletContext().getAttribute("users")).getByUsername(username);
        LocalDateTime dateTime = LocalDateTime.now();

        Order order = new Order(user, cat, dateTime);
        ((OrderRepository)this.getServletContext().getAttribute("orders")).addOrder(order);
        resp.sendRedirect("/cats/all");
    }
}
