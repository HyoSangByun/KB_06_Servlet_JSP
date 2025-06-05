package org.scoula.ex06.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FunctionalInterface //함수형 인터페이스
public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
