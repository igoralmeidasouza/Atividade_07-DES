/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade_07.des;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Almeida
 */
public class Carros_interacao {
    
    private Connection con;

    public Carros_interacao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public String insertCarros(Carros_objeto carros) {
       String sql = "insert into carros(placa, cor, decricao) values(?,?,?)";
       try {
           PreparedStatement prepare = getCon().prepareStatement(sql);
           prepare.setString (1, carros.getPlaca());
           prepare.setString (2, carros.getCor());
           prepare.setString (3, carros.getDescricao());
           
           if (prepare.executeUpdate() > 0){
               return "Cadastrado com sucesso!";
           }
           else{
               return "Erro ao cadastrar";
           }
       }
       catch (SQLException ex){
           return ex.getMessage();
       }
              
   } 
   public String alterarCarro(Carros_objeto carros){
       String sql = "update carros set cor = ?,decricao = ? where placa=?";
        try {
           PreparedStatement prepare = getCon().prepareStatement(sql);

           prepare.setString (1, carros.getCor());
           prepare.setString (2, carros.getDescricao());
           prepare.setString (3, carros.getPlaca());
           
           if (prepare.executeUpdate() > 0){
               return "Alterado com sucesso!";
           }
           else{
               return "Erro ao alterar";
           }
       }
       catch (SQLException ex){
           return ex.getMessage();
       }
   }
   
   public String excluirCarro(Carros_objeto carros){
        String sql = "delete from carros where Placa = ?";
        
        try {
           PreparedStatement prepare = getCon().prepareStatement(sql);

           prepare.setString (1, carros.getPlaca());
           
           if (prepare.executeUpdate() > 0){
               return "Excluido com sucesso!";
           }
           else{
               return "Erro ao excluir";
           }
       }
       catch (SQLException ex){
           return ex.getMessage();
       }
   }
   public List<Carros_objeto> listarTudo(){
       String sql = "select * from carros";
       List<Carros_objeto> lista_carros = new ArrayList<>();
       

       try {
            PreparedStatement prepare = getCon().prepareStatement(sql);

            ResultSet rs = prepare.executeQuery();
            if(rs != null){
                while(rs.next()){
                Carros_objeto cB = new Carros_objeto();
                cB.setPlaca(rs.getString(1));
                cB.setCor(rs.getString(2));
                cB.setDescricao(rs.getString(3));

                lista_carros.add(cB);
                }
                return lista_carros;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
   }
    
}
