/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 0057132
 */
public class distribuidor {
    private String nome;
    private String dataDOPedido;
    private String dataDaEntrega;
    private String produtos;

    public distribuidor() {
       this.nome = null;
        this.dataDOPedido = null;
        this.dataDaEntrega = null;
        this.produtos = null; 
    }

    public distribuidor(String nome, String dataDOPedido, String dataDaEmtrega, String produtos) {
        this.nome = nome;
        this.dataDOPedido = dataDOPedido;
        this.dataDaEntrega = dataDaEmtrega;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDOPedido() {
        return dataDOPedido;
    }

    public void setDataDOPedido(String dataDOPedido) {
        this.dataDOPedido = dataDOPedido;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(String dataDaEmtrega) {
        this.dataDaEntrega = dataDaEmtrega;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }
    
}
