/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.Entidades;

import java.util.Date;

/**
 *
 * @author Julio
 */
public class VendaEnt {

    private String Produto;
    private String vendedor;

    /////////////
    private String cliente;
    private String endereco;
    private String telefone;
    private String Cidade;
    /////////////////
    private String Cartao;
    private String Cheque;
    private String Metodo;
    private int qnt;
    private int qntExistente;//verifica a quantidade de produtos existentes.
    private int ParcelasQnt;
    private int cod;
    private float ValorVenda;
    private float Preco;
    private float ValorParcela;
    private Boolean verifica;
    private int id;//id do produto no banco de dados
    private int codVenda;//Codigo da venda no banco que poder ser 1 ou 0

    private String data;// data que a venda foi realizada
    private String dataContato;// data que a venda foi realizada

    private Date Dt1;//data composta 1
    private int CodigoData;
    private Date Dt2;//data composta 2

    //Produtos:
    //1 Purificador
    //2 Refil
    //3 Peças

    /*
    Métodos:
    1:A vista;
    2:Cartão;
    3:Cheque; 
     */
    public Date getDt1() {
        return Dt1;
    }

    public void setDt1(Date Dt1) {
        this.Dt1 = Dt1;
    }

    public Date getDt2() {
        return Dt2;
    }

    public void setDt2(Date Dt2) {
        this.Dt2 = Dt2;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCodigoData() {
        return CodigoData;
    }

    public void setCodigoData(int CodigoData) {
        this.CodigoData = CodigoData;
    }

    public int getQntExistente() {
        return qntExistente;
    }

    public void setQntExistente(int qntExistente) {
        this.qntExistente = qntExistente;
    }

    public float getValorParcela() {
        return ValorParcela;
    }

    public void setValorParcela(float ValorParcela) {
        this.ValorParcela = ValorParcela;
    }

    public float getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(float ValorVenda) {
        this.ValorVenda = ValorVenda;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String Metodo) {
        this.Metodo = Metodo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getCartao() {
        return Cartao;
    }

    public void setCartao(String Cartao) {
        this.Cartao = Cartao;
    }

    public String getCheque() {
        return Cheque;
    }

    public void setCheque(String Cheque) {
        this.Cheque = Cheque;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Boolean getVerifica() {
        return verifica;
    }

    public void setVerifica(Boolean verifica) {
        this.verifica = verifica;
    }

    public int getParcelasQnt() {
        return ParcelasQnt;
    }

    public void setParcelasQnt(int ParcelasQnt) {
        this.ParcelasQnt = ParcelasQnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataContato() {
        return dataContato;
    }

    public void setDataContato(String dataContato) {
        this.dataContato = dataContato;
    }

}
