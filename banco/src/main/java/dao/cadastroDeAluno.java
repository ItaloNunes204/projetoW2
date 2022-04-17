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
import model.aluno;
public class cadastroDeAluno {
         public void cadastroDeAluno(){
         
     }
    public void cadastroDeAluno(aluno a){
     try {
            String SQL="INSERT INTO italo_pereira.aluno (nome,sobrenome,senha,e_mail,CPF)VALUES(?,?,?,?,?)";
            Connection minhaco=conexaoD.getConexao();
            PreparedStatement comando=minhaco.prepareStatement(SQL);
            comando.setString(1, a.getNome());
            comando.setString(2, a.getSobrenome());
            comando.setString(3, a.getSenha());
            comando.setString(4, a.getEmail());
            comando.setString(5, a.getCpf());
            int retorno=comando.executeUpdate();
            minhaco.close();
            if(retorno>0){
               JOptionPane.showMessageDialog(null,"aluno "+a.getNome()+" inserido com sucesso.");
            }else{
                JOptionPane.showMessageDialog(null,"erro no cadastro "+a.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDeAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public List <aluno> listaDeAlunos(){
        try {
            String SQL="SELECT nome,sobrenome,senha,e_mail FROM italo_pereira.usuário";
            List <aluno>listaDeAlunos=new ArrayList<aluno>();
            Connection c =conexaoD.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                aluno atual = new aluno();
                atual = this.pegaDados(resultado);
                listaDeAlunos.add(atual);
            }
            
            return listaDeAlunos;
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDeAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    private aluno pegaDados(ResultSet resultado){
        try {
            aluno atual=new aluno();
            atual.setNome(resultado.getString("nome"));
            atual.setSobrenome(resultado.getString("sobrenome"));
            atual.setSenha(resultado.getString("senha"));
            atual.setEmail(resultado.getString("e_mail"));
            atual.setCpf(resultado.getString("cpf"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDeAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
