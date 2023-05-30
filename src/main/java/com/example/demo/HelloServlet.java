package com.example.demo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", count + 1);
        }

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Count =  " + session.getAttribute("count") +  "</h1>");
        out.println("</body></html>");
    }

//    String name = request.getParameter("name");
//    String surname = request.getParameter("surname");
//
//        response.setContentType("text/html");
//
//    // Hello
//    PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1> Hello " + name + " " + surname +  "</h1>");
//        out.println("</body></html>");

}