package com.db;

import java.sql.*;

/**
 * Created by wanglei on 16/5/5.
 */
public class DbChange {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://115.29.10.121:3306/souche_finance_loan","root","dpjA8Z6XPXbvos");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from fl_region  ");

        while (resultSet.next()){
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            char indexCharacter = PinyinTool.cn2Pinyin(name).charAt(0);
            String updateSql = "update fl_region  set char_index = '" + indexCharacter + "' where region_id=" + id;
            System.out.println(updateSql);
            connection.createStatement().executeUpdate(updateSql);
        }

    }
}
