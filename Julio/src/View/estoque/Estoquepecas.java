/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.estoque;

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
@Table(name = "estoquepecas", catalog = "tcc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Estoquepecas.findAll", query = "SELECT e FROM Estoquepecas e")
    , @NamedQuery(name = "Estoquepecas.findByNome", query = "SELECT e FROM Estoquepecas e WHERE e.nome = :nome")
    , @NamedQuery(name = "Estoquepecas.findByQnt", query = "SELECT e FROM Estoquepecas e WHERE e.qnt = :qnt")
    , @NamedQuery(name = "Estoquepecas.findById", query = "SELECT e FROM Estoquepecas e WHERE e.id = :id")})
public class Estoquepecas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "nome")
    private String nome;
    @Column(name = "qnt")
    private Integer qnt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Estoquepecas() {
    }

    public Estoquepecas(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        Integer oldQnt = this.qnt;
        this.qnt = qnt;
        changeSupport.firePropertyChange("qnt", oldQnt, qnt);
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
        if (!(object instanceof Estoquepecas)) {
            return false;
        }
        Estoquepecas other = (Estoquepecas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.estoque.Estoquepecas[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
