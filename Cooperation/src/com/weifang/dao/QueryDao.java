package com.weifang.dao;

import com.weifang.entity.Area;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @ClassName: QueryDao
 * @version: 1.0
 * @description: 查询区域信息
 * @author: zhezhi
 * @create: 2022-06-01 14:06
 **/

public class QueryDao {
    public List<Area> queryAreaList(String province) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/zhezhi";
        String user = "root";
        String password = "294753qQ";
        List<Area> areaList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            String sql;
            if (province.equals("")) {
                sql = "select code,name from t_area where pcode = 'null'";
                ps = conn.prepareStatement(sql);
            }else {
                sql = "select code,name from t_area where pcode = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,province);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area area = new Area();
                area.setCode(code);
                area.setName(name);
                areaList.add(area);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return areaList;
    }
}
