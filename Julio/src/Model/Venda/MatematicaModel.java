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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class MatematicaModel {

    public float soma() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        float sum = 0;

        try {

            String sql = "SELECT SUM(preco) FROM vendaprimaria";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                sum = rs.getFloat("SUM(preco)");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao capturar nos números: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return sum;
    }

}
