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
import model.distribuidor;
public class cadastroDeDistribuidoras {
             public void cadastroDeDistribuidoras(){
         
     }
    public void cadastroDeDistribuidoras(distribuidor a){
     try {
            String SQL="INSERT INTO italo_pereira.distribuidor (nome,datadopedido,datadaentrega,produtos)VALUES(?,?,?,?)";
            Connection minhaco=conexaoD.getConexao();
            PreparedStatement comando=minhaco.prepareStatement(SQL);
            comando.setString(1,a.getNome());
            comando.setString(2, a.getDataDOPedido());
            comando.setString(3, a.getDataDaEntrega());
            comando.setString(4, a.getProdutos());
            int retorno=comando.executeUpdate();
            minhaco.close();
            if(retorno>0){
               JOptionPane.showMessageDialog(null,"distribuidora "+a.getNome()+" inserido com sucesso.");
            }else{
                JOptionPane.showMessageDialog(null,"erro no cadastro "+a.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDeDistribuidoras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public List <distribuidor> listaDeDistribuidoras(){
        try {
            String SQL="SELECT nome,datadopedido,datadaentrega,produtos FROM italo_pereira.distribuidor";
            List <distribuidor>listaDeDistribuidoras=new ArrayList<distribuidor>();
            Connection c =conexaoD.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                distribuidor atual = new distribuidor();
                atual = this.pegaDados(resultado);
                listaDeDistribuidoras.add(atual);
            }
            
            return listaDeDistribuidoras;
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDeDistribuidoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    private distribuidor pegaDados(ResultSet resultado){
        try {
            distribuidor atual=new distribuidor();
            atual.setNome(resultado.getString("nome"));
            atual.setDataDOPedido(resultado.getString("dataDOPedido"));
            atual.setDataDaEntrega(resultado.getString("dataDaEntrega"));
            atual.setProdutos(resultado.getString("produtos"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDeDistribuidoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
