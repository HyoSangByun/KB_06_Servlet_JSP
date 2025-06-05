package org.scoula.ex06;

import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

import javax.servlet.annotation.WebServlet;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", value = "/")
// DispatcherServlet Servlet을 상속 받아createMap() 메서드 오버라이딩
// -> 기존 init() 메서드에 작성한 url, 커맨드 매핑 코드를 createMap()에 작성
public class FrontControllerServlet extends DispatcherServlet {
    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
        getMap.put("/", homeController::getIndex);
        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);
        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }
}
