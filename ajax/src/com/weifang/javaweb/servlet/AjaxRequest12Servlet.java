package com.weifang.javaweb.servlet;

import com.alibaba.fastjson.JSON;
import com.weifang.javaweb.bean.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @ClassName: AjaxRequest12Servlet
 * @version: 1.0
 * @description: 省市联动
 * @author: zhezhi
 * @create: 2022-05-27 14:27
 **/

@WebServlet("/ajaxRequest12/*")
public class AjaxRequest12Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        if ((contextPath+"/ajaxRequest12/getProvince").equals(requestURI)) {
            getProvince(request,response);
        }else if ((contextPath+"/ajaxRequest12/getCity").equals(requestURI)) {
            getCity(request,response);
        }
    }

    private void getCity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String pcode = request.getParameter("province");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //Map<String,String> cityMap= new HashMap<>();
        //List<Map<String,String>> cityList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhezhi","root","294753qQ");
            String sql = "select code,name from t_area where pcode = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,pcode);
            rs = ps.executeQuery();
            while (rs.next()) {
               /* Map<String,String> cityMap= new HashMap<>();
                cityMap.put("code",rs.getString("code"));
                cityMap.put("name",rs.getString("name"));
                cityList.add(cityMap);*/
                Area area = new Area();
                area.setCode(rs.getString("code"));
                area.setName(rs.getString("name"));
                areaList.add(area);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //String jsonString = JSON.toJSONString(cityList);
        String jsonString = JSON.toJSONString(areaList);
        out.print(jsonString);

    }

    protected void getProvince(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //Map<String,String> cityMap= new HashMap<>();
        //List<Map<String,String>> ProvinceList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhezhi","root","294753qQ");
            String sql = "select code,name from t_area where pcode = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"null");
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Map<String,String> ProvinceMap= new HashMap<>();
                //可以创建一个类用于存储省份信息 Area 属性 code name
                ProvinceMap.put("code",rs.getString("code"));
                ProvinceMap.put("name",rs.getString("name"));
                ProvinceList.add(ProvinceMap);*/
                Area area = new Area();
                area.setCode(rs.getString("code"));
                area.setName(rs.getString("name"));
                areaList.add(area);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //String jsonString = JSON.toJSONString(ProvinceList);
        String jsonString = JSON.toJSONString(areaList);
        out.print(jsonString);
    }
}
