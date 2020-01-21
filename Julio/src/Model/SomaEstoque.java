/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ConnectionFactory;
import Control.Entidades.EstoqueEnt;
import Control.Entidades.RefilEnt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class SomaEstoque {

    public String SomaAp(EstoqueEnt e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT SUM(qnt) as soma FROM estoquepurificador");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                e.setAparelho(resultado.getString("soma"));
               }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return e.getAparelho();
    }

    public String SomaRef(EstoqueEnt e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT SUM(qnt)as soma FROM estoquerefis");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                e.setRefil(resultado.getString("soma"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return e.getRefil();
    }

    public String SomaPecas(EstoqueEnt e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT SUM(qnt)as soma  FROM estoquepecas");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                e.setPecas(resultado.getString("soma"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return e.getPecas();

    }
}
