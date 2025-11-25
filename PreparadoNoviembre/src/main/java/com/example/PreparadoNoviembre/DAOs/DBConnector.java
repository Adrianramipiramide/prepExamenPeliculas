package com.example.PreparadoNoviembre.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection conexion;

    private DBConnector() {
    }

    public static Connection getInstance() {

        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://database-juego.cvxk5vjw0fki.us-east-1.rds.amazonaws.com/Cine","admin","monzon2025");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
}