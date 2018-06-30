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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Create a Cat!</h1>\n" +
                "<div>\n" +
                "    <form action=\"/cats/create\" method=\"post\">\n" +
                "        <div>\n" +
                "            <label>Name:</label>\n" +
                "            <input type=\"text\" , name=\"name\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>Breed:</label>\n" +
                "            <input type=\"text\" , name=\"breed\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>Color:</label>\n" +
                "            <input type=\"text\" , name=\"color\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>Number of legs:</label>\n" +
                "            <input type=\"number\" , name=\"legs\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <button type=\"submit\">Create Cat</button>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "<br/>\n" +
                "<a href=\"/\">Back to Home</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        int legs = Integer.parseInt(req.getParameter("legs"));

        Cat cat = new Cat(name, breed, color, legs);

        Object object = this.getServletContext().getAttribute(WebConstants.ALL_CATS_ATTRIBUTE_NAME);
        if(object == null) {
            Map<String, Cat> map = new HashMap<String, Cat>();
            map.put(name, cat);
            this.getServletContext().setAttribute(WebConstants.ALL_CATS_ATTRIBUTE_NAME, map);
        } else {
            Map<String, Cat> map = (Map<String, Cat>) this.getServletContext().getAttribute(WebConstants.ALL_CATS_ATTRIBUTE_NAME);
            map.putIfAbsent(name, cat);
        }



        resp.sendRedirect("/cats/profile?catName="+name);
    }
}
