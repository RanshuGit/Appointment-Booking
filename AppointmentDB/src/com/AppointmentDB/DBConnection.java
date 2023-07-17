package com.AppointmentDB;

import java.sql.*;
public class DBConnection {
    static Connection con;
    public static Connection createConnection() {
        try{
            String user="root";
            String pass="";
            String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";

            con= DriverManager.getConnection(url,user,pass);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}