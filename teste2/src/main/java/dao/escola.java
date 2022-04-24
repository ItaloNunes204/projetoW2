package dao;
import conexao.conexaoD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.funcionario;
public class escola {
             public void castroDeEscolas(){
         
     }
    public   boolean atualizaDados(funcionario a) throws SQLException{
        try{
        String SQL="UPDATE italo_pereira.escola SET  numerodeprodutos = ? WHERE numerodeprodutos = ?";
            Connection minhaConexao = conexaoD.getConexao();
            PreparedStatement comando = minhaConexao.prepareStatement(SQL);
            comando.setInt(1, a.getNumeroDeProdutos());
            comando.setInt(2, a.getNumeroDeProdutos()+1);
            int retorno = comando.executeUpdate();
            minhaConexao.close();
            if (retorno > 0) {
                return true;
            }
        }catch (SQLException ex) {
            Logger.getLogger(escola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    public void castroDeEscolas(funcionario a){
     try {
            String SQL="INSERT INTO italo_pereira.escola (nomedofunci,numerodeprodutos)VALUES(?,?)";
            Connection minhaco=conexaoD.getConexao();
            PreparedStatement comando=minhaco.prepareStatement(SQL);
            comando.setString(1,a.getNome());
            comando.setInt(2, a.getNumeroDeProdutos());
            int retorno=comando.executeUpdate();
            minhaco.close();
            if(retorno>0){
               JOptionPane.showMessageDialog(null,"usuario "+a.getNome()+" inserido com sucesso.");
            }else{
                JOptionPane.showMessageDialog(null,"erro no cadastro "+a.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(escola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public List <funcionario> listaDeEscolas(){
        try {
            String SQL="SELECT nomedofunci,numerodeprodutos FROM italo_pereira.escola";
            List <funcionario>listaDeEscolas=new ArrayList<funcionario>();
            Connection c =conexaoD.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                funcionario atual = new funcionario();
                atual = this.pegaDados(resultado);
                listaDeEscolas.add(atual);
            }
            
            return listaDeEscolas;
        } catch (SQLException ex) {
            Logger.getLogger(escola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    private funcionario pegaDados(ResultSet resultado){
        try {
            funcionario atual=new funcionario();
            atual.setNome(resultado.getString("nomedofunci"));
            atual.setNumeroDeProdutos(resultado.getInt("numeroDeProdutos"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(escola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
