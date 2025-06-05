package org.scoula.ex06;

import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet(name = "frontControllerServlet", value = "/")
public abstract class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap; //get 요청처리
    Map<String, Command> postMap; //post 요청처리

    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }

    protected abstract void createMap(Map<String, Command> getMap, Map<String, Command> postMap);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = getCommand(req);
        if (command != null) { // url이 일치하는 커맨드가 있으면 실행
            execute(command, req, resp);
        } else { //404 에러 처리
            String view = prefix + "404" + suffix;
            req.getRequestDispatcher(view).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Command를 실행하여 View 이름 얻어오기
        String viewName = command.execute(req, resp);

        // 얻어온 View 이름이 "redirect:"로 시작하는 경우 Redirect
        if (viewName.startsWith("redirect:")) { // redirect 처리
            resp.sendRedirect(viewName.substring("redirect:".length()));
        }

        // 나머지 경우는 접두사/접미사를 붙여 JSP로 Forward
        else {
            String view = prefix + viewName + suffix;
            req.getRequestDispatcher(view).forward(req, resp);
        }
    }

    /**
     * 요청 URI에서 contextPath를 제외한 나머지를 커맨드 이름으로 사용
     * @param req
     * @return
     */
    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);

        Command command = null;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }

        return command;
    }
}
