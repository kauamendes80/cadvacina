package com.example.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection conectar() {
        Connection conn = null;
        String url = "jdbc:postgresql://dpg-crgru4qj1k6c73do1gf0-a.oregon-postgres.render.com:5432/cadvacinas_gypf_rcrs";
        String username = "cad_vacinas_senac_user";
        String password = "tSHiCc1QVHCwsd93zbGRNOSCbe9NoEA9";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Erro: Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
        }
        return conn;
    }

    public void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Não conseguiu desconectar do BD.");
        }
    }
}
