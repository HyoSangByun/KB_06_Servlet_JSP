package org.scoula.dyanamicweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseServlet", urlPatterns = {"/response"})
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 한글이 깨지지 않도록 응답 문자셋 설정
        resp.setContentType("text/plain; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("ResponseServlet 요청 성공");
    }
}
