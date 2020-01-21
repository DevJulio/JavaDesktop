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
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class InsereBancoPrimarioPt2 {

    public void atualizaCompraValorTotalVenda(float valortotal) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vendaprimaria SET ValorTotalVenda = ? WHERE ValorTotalVenda = ?");
            stmt.setFloat(1, valortotal);
            stmt.setFloat(2, 0);

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        }
        //////////////////////////////Inserção no outro banco//////////////////////////////////////////////////////////
        try {
            stmt = con.prepareStatement("UPDATE vendafinal SET ValorTotalVenda = ? WHERE ValorTotalVenda = ?");
            stmt.setFloat(1, valortotal);
            stmt.setFloat(2, 0);

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void atualizaCompraMetodoDePagamento(String metodo) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vendaprimaria SET MetodoDePagamento = ? WHERE MetodoDePagamento = ?");
            stmt.setString(1, metodo);
            stmt.setString(2, "0");
            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        }
        //////////////////////////////Inserção no outro banco//////////////////////////////////////////////////////////
        try {
            stmt = con.prepareStatement("UPDATE vendafinal SET MetodoDePagamento = ? WHERE MetodoDePagamento = ?");
            stmt.setString(1, metodo);
            stmt.setString(2, "0");
            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void atualizaCompraParcelasQnt(int qnt) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vendaprimaria SET ParcelasQnt = ?  WHERE ParcelasQnt = ?");
            stmt.setInt(1, qnt);
            stmt.setInt(2, 0);

            stmt.executeUpdate();

            //  JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        }
        //////////////////////////////Inserção no outro banco//////////////////////////////////////////////////////////
        try {
            stmt = con.prepareStatement("UPDATE vendafinal SET ParcelasQnt = ?  WHERE ParcelasQnt = ?");
            stmt.setInt(1, qnt);
            stmt.setInt(2, 0);

            stmt.executeUpdate();

            //  JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void atualizaCompraValorParcela(float parcela) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vendaprimaria SET ValorParcela = ?  WHERE ValorParcela = ?");
            stmt.setFloat(1, parcela);
            stmt.setFloat(2, 0);

            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        }
        //////////////////////////////Inserção no outro banco//////////////////////////////////////////////////////////

        try {
            stmt = con.prepareStatement("UPDATE vendafinal SET ValorParcela = ?  WHERE ValorParcela = ?");
            stmt.setFloat(1, parcela);
            stmt.setFloat(2, 0);

            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void atualizaCodigoVenda() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
         try {
            stmt = con.prepareStatement("UPDATE vendafinal SET codigoVenda = ?  WHERE codigoVenda = ?");
            stmt.setInt(1, 1);
            stmt.setInt(2, 0);

            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }

}
