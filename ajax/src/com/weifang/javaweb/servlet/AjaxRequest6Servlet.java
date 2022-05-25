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
 * @ClassName: AjaxRequest6Servlet
 * @version: 1.0
 * @description: XML发送学生信息
 * @author: zhezhi
 * @create: 2022-05-25 15:42
 **/

@WebServlet("/ajaxRequest6")
public class AjaxRequest6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder xmlStr = new StringBuilder();
        xmlStr.append("<students>");
        xmlStr.append("<student>");
        xmlStr.append("    <name>张三</name>");
        xmlStr.append("    <age>14</age>");
        xmlStr.append("</student>");
        xmlStr.append("<student>");
        xmlStr.append("    <name>李四</name>");
        xmlStr.append("    <age>24</age>");
        xmlStr.append("</student>");
        xmlStr.append("</students>");
        out.print(xmlStr);
    }
}
