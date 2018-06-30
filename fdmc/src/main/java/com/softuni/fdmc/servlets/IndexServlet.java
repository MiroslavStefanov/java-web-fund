package com.softuni.fdmc.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>\n" +
                "    <h3>Navigate through the application using the links below!</h3>\n" +
                "    <hr/>\n" +
                "    <a href=\"/cats/create\">Create Cat</a>\n" +
                "    <br/>\n" +
                "    <a href=\"/cats/all\">All Cats</a>");
    }
}
