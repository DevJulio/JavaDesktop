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
@Table(name = "estoquerefis", catalog = "tcc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Estoquerefis.findAll", query = "SELECT e FROM Estoquerefis e")
    , @NamedQuery(name = "Estoquerefis.findByModelo", query = "SELECT e FROM Estoquerefis e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "Estoquerefis.findByQnt", query = "SELECT e FROM Estoquerefis e WHERE e.qnt = :qnt")
    , @NamedQuery(name = "Estoquerefis.findById", query = "SELECT e FROM Estoquerefis e WHERE e.id = :id")})
public class Estoquerefis implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "qnt")
    private int qnt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Estoquerefis() {
    }

    public Estoquerefis(Integer id) {
        this.id = id;
    }

    public Estoquerefis(Integer id, int qnt) {
        this.id = id;
        this.qnt = qnt;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        int oldQnt = this.qnt;
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
        if (!(object instanceof Estoquerefis)) {
            return false;
        }
        Estoquerefis other = (Estoquerefis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.estoque.Estoquerefis[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
