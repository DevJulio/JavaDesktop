/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Entidades.ClienteEnt;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.PecasEnt;
import Control.Entidades.RefilEnt;
import Control.Transforma;
import Model.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class ListarComboBox {

    public List<PurificadorEnt> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PurificadorEnt> aparelho = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM detalhepurificadormodelo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PurificadorEnt ap = new PurificadorEnt();

                ap.setModelo(rs.getString("modelo"));

                aparelho.add(ap);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListarComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aparelho;

    }

    public List<PurificadorEnt> readCor() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PurificadorEnt> cor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM detalhepurificadorcor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PurificadorEnt ap = new PurificadorEnt();

                ap.setCor(rs.getString("cor"));

                cor.add(ap);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListarComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cor;

    }

    public List<RefilEnt> readRefil() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<RefilEnt> refil = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoquerefis");
            rs = stmt.executeQuery();

            while (rs.next()) {

                RefilEnt ap = new RefilEnt();

                ap.setModelo(rs.getString("modelo"));

                refil.add(ap);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListarComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return refil;

    }

    public List<PecasEnt> readPecas() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PecasEnt> pecas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoquepecas");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PecasEnt ap = new PecasEnt();

                ap.setNome(rs.getString("nome"));

                pecas.add(ap);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListarComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pecas;

    }

   
}
