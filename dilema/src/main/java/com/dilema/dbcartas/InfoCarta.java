package com.dilema.dbcartas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dilema.classes.Sorteador;

public class InfoCarta {
    private String hist;
    private String just;

    public String getHist() {
        return hist;
    }
    public String getJust() {
        return just;
    }

    public void obterConteudo(int tipoCarta) {
        ArrayList<Integer> listaId = listaCartas(tipoCarta);

        Sorteador sorteador = new Sorteador();
        int idCarta = sorteador.sortrearIdCarta(listaId.size());
        
        conteudoCarta(listaId,idCarta);
        
    }

    public ArrayList<Integer> listaCartas(int tipoCarta) {
        ConnectionFactory factory = new ConnectionFactory();
        ArrayList<Integer> listaId = new ArrayList<>();
        try (Connection c = factory.obtemConexao()) {

            String sql = "SELECT idCartas FROM cartas WHERE idTipo = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, tipoCarta); // Definindo o parâmetro da consulta

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCarta = rs.getInt("idCartas");
                listaId.add(idCarta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaId;
    }
    public void conteudoCarta(ArrayList<Integer> listaIdCartas,int idCarta){
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            String sql = "SELECT historia,justificativa FROM cartas WHERE idCartas = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, listaIdCartas.get(idCarta)); // Definindo o parâmetro da consulta
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hist = rs.getString("historia");
                just = rs.getString("justificativa");
            }

            
        } catch (Exception e){
            e.printStackTrace();
            }
    }


    public static void main(String[] args) {
        InfoCarta in = new InfoCarta();
        
        in.obterConteudo(2);

        

    }
}