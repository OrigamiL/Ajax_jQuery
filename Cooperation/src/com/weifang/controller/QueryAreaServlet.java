package com.weifang.controller;

import com.alibaba.fastjson.JSON;
import com.weifang.dao.QueryDao;
import com.weifang.entity.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @ClassName: QueryAreaServlet
 * @version: 1.0
 * @description: 查询省市
 * @author: zhezhi
 * @create: 2022-06-01 14:25
 **/

@WebServlet("/query")
public class QueryAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String province = request.getParameter("province");
        QueryDao dao = new QueryDao();
        List<Area> areaList = null;
        if (province == null) {
            areaList = dao.queryAreaList(null);
        }else {
            areaList = dao.queryAreaList(province);
        }
        String jsonString = JSON.toJSONString(areaList);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(jsonString);
    }
}
