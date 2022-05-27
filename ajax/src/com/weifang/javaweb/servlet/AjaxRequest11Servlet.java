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
 * @ClassName: AjaxRequest11Servlet
 * @version: 1.0
 * @description: 封装ajax
 * @author: zhezhi
 * @create: 2022-05-27 10:10
 **/

@WebServlet("/ajaxRequest11")
public class AjaxRequest11Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        out.print("{\"username\":\""+username+"\"}");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        out.print("{\"username\":\""+username+"\"}");
    }
}
