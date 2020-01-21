/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Venda;

import Control.Entidades.VendaEnt;
import Model.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class InsereBancoPrimario {

    ProcuraQnt p = new ProcuraQnt();
    Random gerador = new Random();

    public void cadastraVendaPrimaria(VendaEnt v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        int qnt = 0;
        if (v.getCod() == 1) {
            qnt = p.QntProcuraP(v);
        } else if (v.getCod() == 2) {
            qnt = p.QntProcuraR(v);
        } else if (v.getCod() == 3) {
            qnt = p.QntProcuraPe(v);
        }
        
        try {
            stmt = con.prepareStatement("INSERT INTO vendaPrimaria (produto, vendedor ,preco ,qnt, cod, ValorTotalVenda, MetodoDePagamento, ParcelasQnt, ValorParcela, ProdutoQnt, IdProduto,DataCompra,DataContato,codigoVenda)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, v.getProduto());
            stmt.setString(2, v.getVendedor());
            stmt.setFloat(3, v.getPreco());
            stmt.setInt(4, v.getQnt());
            stmt.setInt(5, v.getCod());
            stmt.setFloat(6, 0);
            stmt.setString(7, "0");
            stmt.setInt(8, 0);
            stmt.setFloat(9, 0);
            stmt.setInt(10, qnt - v.getQnt());
            stmt.setInt(11, v.getId());
            stmt.setString(12, v.getData());
            stmt.setString(13, v.getDataContato());
            stmt.setInt(14, 0);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar o produto, verifique os campos e tente novamente: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }

    public void cadastraTodasAsVendasPrimarias(VendaEnt v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        int qnt = 0;
        if (v.getCod() == 1) {
            qnt = p.QntProcuraP(v);
        } else if (v.getCod() == 2) {
            qnt = p.QntProcuraR(v);
        } else if (v.getCod() == 3) {
            qnt = p.QntProcuraPe(v);
        }

        try {
            stmt = con.prepareStatement("INSERT INTO vendafinal (produto, vendedor ,preco ,qnt, cod, ValorTotalVenda, MetodoDePagamento, ParcelasQnt, ValorParcela, ProdutoQnt,"
                    + "IdProduto,DataCompra,DataContato,codigoVenda,Cliente,Endereco,Telefone,Cidade,DataCodigo)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, v.getProduto());
            stmt.setString(2, v.getVendedor());
            stmt.setFloat(3, v.getPreco());
            stmt.setInt(4, v.getQnt());
            stmt.setInt(5, v.getCod());
            stmt.setFloat(6, 0);
            stmt.setString(7, "0");
            stmt.setInt(8, 0);
            stmt.setFloat(9, 0);
            stmt.setInt(10, qnt - v.getQnt());
            stmt.setInt(11, v.getId());
            stmt.setString(12, v.getData());
            stmt.setString(13, v.getDataContato());
            stmt.setInt(14, 0);
            stmt.setString(15, v.getCliente());
            stmt.setString(16, v.getEndereco());
            stmt.setString(17, v.getTelefone());
            stmt.setString(18, v.getCidade());
            stmt.setInt(19, v.getCodigoData());
            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar o produto, verifique os campos e tente novamente: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
