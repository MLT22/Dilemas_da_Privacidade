package com.dilema.dbcartas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String usuario = "avnadmin";
    private String senha = "AVNS_ED9Kh0F0zRxG3LATyxW";
    private String host = "mysql-3f0f63dd-malutagustavo-623e.b.aivencloud.com";
    private String porta = "16586";
    private String bd = "defaultdb";

    public Connection obtemConexao() {
        try {
            String url = "jdbc:mysql://" + host + ":" + porta + "/" + bd + "?useSSL=true&requireSSL=true";
            Connection c = DriverManager.getConnection(url, usuario, senha);
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}