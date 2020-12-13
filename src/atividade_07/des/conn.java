/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade_07.des;

import java.sql.*;

/**
 *
 * @author Igor Almeida
 */
public class conn {
    public static Connection abrir(){
        Connection con = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                String url="jdbc:mysql://127.0.0.1/estacionamento?user=root&password=";

                con = DriverManager.getConnection(url);
                System.out.println("Conexão aberta!");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return con;
    }
    
    public static void fechar(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Conexão fechada!");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
