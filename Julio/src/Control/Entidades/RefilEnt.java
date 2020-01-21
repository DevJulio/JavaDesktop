/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.Entidades;

/**
 *
 * @author Julio
 */
public class RefilEnt {
    
    private float preco;
    private String modelo;
    private int qnt;
    private int qntadd;

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public int getQntadd() {
        return qntadd;
    }

    public void setQntadd(int qntadd) {
        this.qntadd = qntadd;
    }
    
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    

    @Override
    public String toString() {
        return getModelo(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
}
