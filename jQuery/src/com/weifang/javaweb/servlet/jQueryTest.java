package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program:
 * @ClassName: jQueryTest
 * @version: 1.0
 * @description: test
 * @author: zhezhi
 * @create: 2022-05-31 18:03
 **/

@WebServlet("/request1")
public class jQueryTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("aaa");
        out.print("{\"name\":\""+name+"\"}");
    }
}
