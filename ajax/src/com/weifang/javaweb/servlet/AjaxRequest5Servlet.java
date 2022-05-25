package com.weifang.javaweb.servlet;

import com.alibaba.fastjson.JSON;
import com.weifang.javaweb.bean.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @ClassName: AjaxRequest5Servlet
 * @version: 1.0
 * @description: test
 * @author: zhezhi
 * @create: 2022-05-24 14:04
 **/
@WebServlet("/ajaxRequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       // StringBuilder jsonStr = new StringBuilder();
        //   jsonStr.append("[");
        List<Student> studentList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhezhi","root","294753qQ");
            String sql = "select name,age,address from t_student_ajax";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                student.setName(name);
                student.setAge(age);
                student.setAddress(address);
                studentList.add(student);
/*                jsonStr.append("{\"name\":\"");
                jsonStr.append(rs.getString("name"));
                jsonStr.append("\",\"age\":");
                jsonStr.append(rs.getString("age"));
                jsonStr.append(",\"address\":\"");
                jsonStr.append(rs.getString("address"));
                jsonStr.append("\"},");*/
            }
          //  jsonStr.deleteCharAt(jsonStr.length()-1);
          //  jsonStr.append("]");

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
        String jsonStr = JSON.toJSONString(studentList);
        //  String jsonStr = "[{\"name\":\"张三\",\"age\":14,\"address\":\"北京\"},{\"name\":\"李四\",\"age\":23,\"address\":\"上海\"}]";
        out.print(jsonStr);
    }
}
