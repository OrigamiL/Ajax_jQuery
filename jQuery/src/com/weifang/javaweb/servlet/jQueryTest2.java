package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program:
 * @ClassName: jQueryTest2
 * @version: 1.0
 * @description: 练习
 * @author: zhezhi
 * @create: 2022-06-01 11:31
 **/

@WebServlet("/request2")
public class jQueryTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print("{\"name\":\""+name+"\"}");
    }
}
