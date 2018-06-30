package com.softuni.fdmc.servlets;

import com.softuni.fdmc.WebConstants;
import com.softuni.fdmc.entity.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cats/profile")
public class CatProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] query = req.getQueryString().split("=");

        if(query.length <= 1 || !query[0].equals("catName"))
            throw new IllegalArgumentException();

        Map<String, Cat> map = (Map<String, Cat>) this.getServletContext().getAttribute(WebConstants.ALL_CATS_ATTRIBUTE_NAME);
        if(map == null)
            throw new NullPointerException();

        Cat cat = map.get(query[1]);

        PrintWriter writer = resp.getWriter();

        if(cat == null) {
            writer.print("<h1>Cat, with name - " + query[1] + " was not found.</h1>" +
                    "<br/>" +
                    "<a href=\"/cats/all\">Back</a>");
        } else {
            writer.print("<h1>Cat - " + cat.getName() + "</h1>" +
                    "<hr/>" +
                    "<h2>Breed: " + cat.getBreed() +" </h2>" +
                    "<h2>Color: " + cat.getColor() +" </h2>" +
                    "<h2>Number of legs: " + cat.getNumberOfLegs() +" </h2>" +
                    "<hr/>" +
                    "<a href=\"/cats/all\">Back</a>");
        }
    }
}
