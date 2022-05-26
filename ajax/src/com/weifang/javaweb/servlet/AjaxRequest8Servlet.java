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
 * @ClassName: AjaxRequest8Servlet
 * @version: 1.0
 * @description: 测试异步同步
 * @author: zhezhi
 * @create: 2022-05-26 11:36
 **/

@WebServlet("/ajaxRequest8")
public class AjaxRequest8Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.print("响应2");
    }
}
