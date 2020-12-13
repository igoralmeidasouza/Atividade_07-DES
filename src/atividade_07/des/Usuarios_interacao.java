/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade_07.des;

import java.util.ArrayList;
import java.util.List;
//import java.awt.*;
import java.sql.*;

/**
 *
 * @author Igor Almeida
 */
public class Usuarios_interacao {
    private Connection con;

    public Usuarios_interacao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
   public String insertUsuario(Usuarios_objeto usuarios) {
       String sql = "insert into usuarios(CPF,nome,email,login,senha,tipo,telefone) values(?,?,?,?,?,?,?)";
       try {
           PreparedStatement prepare = getCon().prepareStatement(sql);
           prepare.setString (1, usuarios.getCPF());
           prepare.setString (2, usuarios.getNome());
           prepare.setString (3, usuarios.getEmail());
           prepare.setString (4, usuarios.getLogin());
           prepare.setString (5, usuarios.getSenha());
           prepare.setString (6, usuarios.getTipo());
           prepare.setString (7, usuarios.getTelefone());
           
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
   public String alterarUsuario(Usuarios_objeto usuarios){
       String sql = "update usuarios set nome = ?,email = ?,login = ?,senha = ?,tipo = ?,telefone = ? where CPF=?";
        try {
           PreparedStatement prepare = getCon().prepareStatement(sql);

           prepare.setString (1, usuarios.getNome());
           prepare.setString (2, usuarios.getEmail());
           prepare.setString (3, usuarios.getLogin());
           prepare.setString (4, usuarios.getSenha());
           prepare.setString (5, usuarios.getTipo());
           prepare.setString (6, usuarios.getTelefone());
           prepare.setString (7, usuarios.getCPF());
           
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
   
   public String excluirUsuario(Usuarios_objeto usuarios){
        String sql = "delete from usuarios where CPF = ?";
        
        try {
           PreparedStatement prepare = getCon().prepareStatement(sql);

           prepare.setString (1, usuarios.getCPF());
           
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
   public List<Usuarios_objeto> listarTudo(){
       String sql = "select * from usuarios";
       List<Usuarios_objeto> lista_usuarios = new ArrayList<>();
       

       try {
            PreparedStatement prepare = getCon().prepareStatement(sql);

            ResultSet rs = prepare.executeQuery();
            if(rs != null){
                while(rs.next()){
                Usuarios_objeto cB = new Usuarios_objeto();
                cB.setCPF(rs.getString(1));
                cB.setNome(rs.getString(2));
                cB.setEmail(rs.getString(3));
                cB.setLogin(rs.getString(4));
                cB.setSenha(rs.getString(5));
                cB.setTipo(rs.getString(6));
                cB.setTelefone(rs.getString(7));

                lista_usuarios.add(cB);
                }
                return lista_usuarios;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
   }
   public String verificarLogin (Usuarios_objeto usuarios){
       String sql = "select * from usuarios where Login = ? and Senha = ?";
       
       try {
           PreparedStatement prepare = getCon().prepareStatement(sql);

           prepare.setString (1, usuarios.getLogin());
           prepare.setString (2, usuarios.getSenha());
           ResultSet entrar = prepare.executeQuery();
           if (entrar.next()){
               usuarios.setTipo(entrar.getString(6));
               usuarios.setValidar("Logado");
               return "";
           }
           else{
               return "Usuario ou senha invalido";
           }
       }
       catch (SQLException ex){
           return ex.getMessage();
       }
   }
}
