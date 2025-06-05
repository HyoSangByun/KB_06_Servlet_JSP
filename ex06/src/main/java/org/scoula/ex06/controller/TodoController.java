package org.scoula.ex06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TodoController {
    public String getList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> list = Arrays.asList("Todo 1", "Todo 2", "Todo 3");
        req.setAttribute("todoList", list);
        System.out.println("GET /togo/list");
        return "todo/list";
    }

    public String getView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /togo/view");
        return "todo/view";
    }

    public String getCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/create");
        return "todo/create";
    }

    public String postCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("POST /todo/create");
        return "redirect:/todo/list";
    }

    public String getUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GET /todo/update");
        return "todo/update";
    }

    public String postUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("POST /todo/update");
        return "redirect:/todo/list";
    }

    public String postDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("POST /todo/delete");
        return "redirect:/todo/list";
    }
}
