/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 0057132
 */
public class conexaoD {
        private static String url="jdbc:postgresql://200.18.128.54/aula";
    private static String usuario = "aula";
    private static String senha = "aula";
    private static Connection minhaCon=null;
    public static Connection getConexao(){
         try {
        if(conexaoD.minhaCon==null){
          conexaoD.minhaCon=DriverManager.getConnection(url, usuario, senha);
            } 
        return minhaCon;
         } catch (SQLException ex) {
                Logger.getLogger(conexaoD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erro de conexão ao banco de dados"+ex.getMessage());
            }
        return null;
    }
}
