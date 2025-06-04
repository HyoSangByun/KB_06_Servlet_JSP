package org.scoula.demo1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("<style>");
        out.println("div { border: 1px solid #ccc; padding: 10px; width: fit-content; }");
        out.println("h1 { font-size: 24px; }");
        out.println("a { text-decoration: none; color: purple; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<h1>Hello Servlet!</h1>");
        out.println("<a href=\"/\">Home</a>");  // 홈으로 이동하는 링크
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
    }
}