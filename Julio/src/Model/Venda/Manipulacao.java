/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Venda;

import Control.Entidades.PecasEnt;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.RefilEnt;
import Control.Entidades.VendaEnt;
import Model.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class Manipulacao {

    public void AlteraEstoque() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT qnt, cod,ProdutoQnt,IdProduto FROM vendaprimaria");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                int id = resultado.getInt("IdProduto");
                int qnt = resultado.getInt("ProdutoQnt");
                int cod = resultado.getInt("cod");

                if (resultado.getInt("cod") == 1) {

                    atualizaEstoque(qnt, id, cod);

                } else if (resultado.getInt("cod") == 2) {

                    atualizaEstoque(qnt, id, cod);

                } else if (resultado.getInt("cod") == 3) {
                    atualizaEstoque(qnt, id, cod);
                }
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void atualizaEstoque(int qnt, int id, int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "";

        if (cod == 1) {
            sql = "UPDATE estoquepurificador SET qnt = ? where id = ? ";
        } else if (cod == 2) {
            sql = "UPDATE estoquerefis SET qnt = ? where id = ? ";
        } else if (cod == 3) {
            sql = "UPDATE estoquepecas SET qnt = ? where id = ? ";
        }

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, qnt);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            //  JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public int capturaIdP(PurificadorEnt p) {

        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT id FROM estoquepurificador WHERE modelo = ? AND cor= ?");

            stmt.setString(1, p.getModelo());
            stmt.setString(2, p.getCor());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                id = (resultado.getInt("id"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return id;
    }

    public int capturaIdR(RefilEnt r) {

        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT id FROM estoquerefis WHERE modelo = ?");

            stmt.setString(1, r.getModelo());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                id = (resultado.getInt("id"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return id;
    }

    public int capturaIdPe(PecasEnt pe) {

        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT id FROM estoquepecas WHERE nome = ?");

            stmt.setString(1, pe.getNome());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                id = (resultado.getInt("id"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return id;
    }
/////////////////////////////////////////////////////////////////
/*
    public float finalizaTabelaVrV(VendaEnt v) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT ValorTotalVenda FROM `vendaprimaria` WHERE id = ?");
            stmt.setInt(1, 1);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                v.setValorVenda(resultado.getFloat("ValorTotalVenda"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return v.getValorVenda();
    }

    public String finalizaTabelaMdP(VendaEnt v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT MetodoDePagamento FROM `vendaprimaria` WHERE id = ?");
            stmt.setInt(1, 1);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                v.setMetodo(resultado.getString("MetodoDePagamento"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return v.getMetodo();

    }

    public int finalizaTabelaPQ(VendaEnt v) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT ParcelasQnt FROM `vendaprimaria` WHERE id = ?");
            stmt.setInt(1, 1);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                v.setParcelasQnt(resultado.getInt("ParcelasQnt"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return v.getParcelasQnt();

    }
*/
}
