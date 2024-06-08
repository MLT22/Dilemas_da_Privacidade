package com.dilema.dbcartas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String usuario = "avnadmin";
    private String senha = "AVNS_n4T9Cslsr7vo55INp6s";
    private String host = "mysql-107d4fc-malutagustavo-623e.f.aivencloud.com";
    private String porta = "16586";
    private String bd = "defaultdb";

    public Connection obtemConexao() {
        try {
            String url = "jdbc:mysql://" + host + ":" + porta + "/" + bd;
            Connection c = DriverManager.getConnection(url, usuario, senha);
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}