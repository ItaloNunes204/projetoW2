package model;
public class funcionario {
    private String nome;
    private int numeroDeProdutos;

    public funcionario() {
         this.nome = null;
        this.numeroDeProdutos = 0;
    }

    public funcionario(String nome, int numeroDeProdutos) {
        this.nome = nome;
        this.numeroDeProdutos = numeroDeProdutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeProdutos() {
        return numeroDeProdutos;
    }

    public void setNumeroDeProdutos(int numeroDeProdutos) {
        this.numeroDeProdutos = numeroDeProdutos;
    }
    
    
    
}
