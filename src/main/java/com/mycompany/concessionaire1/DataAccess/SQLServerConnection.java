package com.mycompany.concessionaire1.DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    
    Connection connection = null;    
     
    String bd = "BDconcessionaire";
    String ip = "localhost"; 
    String puerto = "1433";
    String user = "usersql";
    String password = "root1";   
    
    public Connection openConnection(){
        try {
            String url = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + bd + ";encrypt=false;trustServerCertificate=true";
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexión establecida correctamente a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
    
    public void closeConnection() {
        try {
            if (connection != null) {
            connection.close();
            System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
        System.out.println("Error al cerrar la conexión: " + e.getMessage());
           }
    }

    CallableStatement prepareCall(String validateAppointmentSql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
