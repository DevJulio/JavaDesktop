/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Venda;

import Control.Entidades.PurificadorEnt;
import Control.Entidades.VendaEnt;
import Model.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class ProcuraQnt {

    public int QntProcuraP(VendaEnt v) {
        int quantidade = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT qnt FROM estoquepurificador WHERE id = ?");
            stmt.setInt(1, v.getId());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                quantidade = (resultado.getInt("qnt"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        System.out.println(quantidade);
        return quantidade;
    }

    public int QntProcuraR(VendaEnt v) {
        int quantidade = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT qnt FROM estoquerefis WHERE id = ?");
            stmt.setInt(1, v.getId());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                quantidade = (resultado.getInt("qnt"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        System.out.println(quantidade);
        return quantidade;
    }
      public int QntProcuraPe(VendaEnt v) {
        int quantidade = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT qnt FROM estoquepecas WHERE id = ?");
            stmt.setInt(1, v.getId());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                quantidade = (resultado.getInt("qnt"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        System.out.println(quantidade);
        return quantidade;
    }

}
