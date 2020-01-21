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
 * @author julio
 */
@Entity
@Table(name = "vendaprimaria", catalog = "tcc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Vendaprimaria.findAll", query = "SELECT v FROM Vendaprimaria v")
    , @NamedQuery(name = "Vendaprimaria.findByProduto", query = "SELECT v FROM Vendaprimaria v WHERE v.produto = :produto")
    , @NamedQuery(name = "Vendaprimaria.findByVendedor", query = "SELECT v FROM Vendaprimaria v WHERE v.vendedor = :vendedor")
    , @NamedQuery(name = "Vendaprimaria.findByPreco", query = "SELECT v FROM Vendaprimaria v WHERE v.preco = :preco")
    , @NamedQuery(name = "Vendaprimaria.findByQnt", query = "SELECT v FROM Vendaprimaria v WHERE v.qnt = :qnt")
    , @NamedQuery(name = "Vendaprimaria.findByValorTotalVenda", query = "SELECT v FROM Vendaprimaria v WHERE v.valorTotalVenda = :valorTotalVenda")
    , @NamedQuery(name = "Vendaprimaria.findByMetodoDePagamento", query = "SELECT v FROM Vendaprimaria v WHERE v.metodoDePagamento = :metodoDePagamento")
    , @NamedQuery(name = "Vendaprimaria.findByParcelasQnt", query = "SELECT v FROM Vendaprimaria v WHERE v.parcelasQnt = :parcelasQnt")
    , @NamedQuery(name = "Vendaprimaria.findByValorParcela", query = "SELECT v FROM Vendaprimaria v WHERE v.valorParcela = :valorParcela")
    , @NamedQuery(name = "Vendaprimaria.findById", query = "SELECT v FROM Vendaprimaria v WHERE v.id = :id")})
public class Vendaprimaria implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "produto")
    private String produto;
    @Basic(optional = false)
    @Column(name = "vendedor")
    private String vendedor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;
    @Basic(optional = false)
    @Column(name = "qnt")
    private int qnt;
    @Basic(optional = false)
    @Column(name = "ValorTotalVenda")
    private float valorTotalVenda;
    @Basic(optional = false)
    @Column(name = "MetodoDePagamento")
    private String metodoDePagamento;
    @Basic(optional = false)
    @Column(name = "ParcelasQnt")
    private int parcelasQnt;
    @Basic(optional = false)
    @Column(name = "ValorParcela")
    private float valorParcela;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Vendaprimaria() {
    }

    public Vendaprimaria(Integer id) {
        this.id = id;
    }

    public Vendaprimaria(Integer id, String produto, String vendedor, int qnt, float valorTotalVenda, String metodoDePagamento, int parcelasQnt, float valorParcela) {
        this.id = id;
        this.produto = produto;
        this.vendedor = vendedor;
        this.qnt = qnt;
        this.valorTotalVenda = valorTotalVenda;
        this.metodoDePagamento = metodoDePagamento;
        this.parcelasQnt = parcelasQnt;
        this.valorParcela = valorParcela;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        String oldProduto = this.produto;
        this.produto = produto;
        changeSupport.firePropertyChange("produto", oldProduto, produto);
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        String oldVendedor = this.vendedor;
        this.vendedor = vendedor;
        changeSupport.firePropertyChange("vendedor", oldVendedor, vendedor);
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        Float oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        int oldQnt = this.qnt;
        this.qnt = qnt;
        changeSupport.firePropertyChange("qnt", oldQnt, qnt);
    }

    public float getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(float valorTotalVenda) {
        float oldValorTotalVenda = this.valorTotalVenda;
        this.valorTotalVenda = valorTotalVenda;
        changeSupport.firePropertyChange("valorTotalVenda", oldValorTotalVenda, valorTotalVenda);
    }

    public String getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(String metodoDePagamento) {
        String oldMetodoDePagamento = this.metodoDePagamento;
        this.metodoDePagamento = metodoDePagamento;
        changeSupport.firePropertyChange("metodoDePagamento", oldMetodoDePagamento, metodoDePagamento);
    }

    public int getParcelasQnt() {
        return parcelasQnt;
    }

    public void setParcelasQnt(int parcelasQnt) {
        int oldParcelasQnt = this.parcelasQnt;
        this.parcelasQnt = parcelasQnt;
        changeSupport.firePropertyChange("parcelasQnt", oldParcelasQnt, parcelasQnt);
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(float valorParcela) {
        float oldValorParcela = this.valorParcela;
        this.valorParcela = valorParcela;
        changeSupport.firePropertyChange("valorParcela", oldValorParcela, valorParcela);
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
        if (!(object instanceof Vendaprimaria)) {
            return false;
        }
        Vendaprimaria other = (Vendaprimaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Venda.Vendaprimaria[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
