package com.prueba.db.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionOracleDB {

    Connection connection = null;

    public DBConnectionOracleDB() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "APP_TESIS", "APP_TESIS");

            if (connection == null) {
                System.out.println("Conexion a Oracle Fallo");
            } else {
                System.out.println("Conexion a Oracle exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }

}
