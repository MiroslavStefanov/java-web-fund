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

@WebServlet("/cats/all")
public class AllCatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<h1> All Cats</h1><hr/>");

        StringBuilder sb = new StringBuilder();

        Map<String, Cat> map = (Map<String, Cat>) this.getServletContext().getAttribute(WebConstants.ALL_CATS_ATTRIBUTE_NAME);
        if(map == null || map.size() == 0) {
            sb.append("<h2>There are no cats.<a href=\"/cats/create\">Create some!</a></h2><br/>");
        } else for(String name : map.keySet()) {
            sb.append("<h2><a href=\"/cats/profile?catName=").append(name).append("\">").append(name).append("</a></h2>");
        }

        sb.append("<a href=\"/\">Back To Home</a>");
        writer.print(sb);
    }
}
