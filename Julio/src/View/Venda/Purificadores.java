/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Venda;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Julio
 */
@Entity
@Table(name = "purificadores", catalog = "tcc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Purificadores.findAll", query = "SELECT p FROM Purificadores p")
    , @NamedQuery(name = "Purificadores.findByCor", query = "SELECT p FROM Purificadores p WHERE p.cor = :cor")
    , @NamedQuery(name = "Purificadores.findByModelo", query = "SELECT p FROM Purificadores p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Purificadores.findByVoltagem", query = "SELECT p FROM Purificadores p WHERE p.voltagem = :voltagem")
    , @NamedQuery(name = "Purificadores.findByPreco", query = "SELECT p FROM Purificadores p WHERE p.preco = :preco")
    , @NamedQuery(name = "Purificadores.findById", query = "SELECT p FROM Purificadores p WHERE p.id = :id")})
public class Purificadores implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "cor")
    private String cor;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "voltagem")
    private String voltagem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Purificadores() {
    }

    public Purificadores(Integer id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        String oldCor = this.cor;
        this.cor = cor;
        changeSupport.firePropertyChange("cor", oldCor, cor);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        String oldVoltagem = this.voltagem;
        this.voltagem = voltagem;
        changeSupport.firePropertyChange("voltagem", oldVoltagem, voltagem);
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        Float oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purificadores)) {
            return false;
        }
        Purificadores other = (Purificadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Venda.Purificadores[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
