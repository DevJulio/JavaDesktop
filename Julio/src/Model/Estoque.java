/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ConnectionFactory;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.FuncionarioEnt;
import Control.Entidades.PecasEnt;
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
public class Estoque {

    public void qntdeaparelho(PurificadorEnt a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("select qnt FROM estoquepurificador where modelo= ? and cor= ?");
            stmt.setString(1, a.getModelo());
            stmt.setString(2, a.getCor());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                a.setQnt(resultado.getInt("qnt"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraEstoqueAparelho(PurificadorEnt a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoquepurificador SET qnt = ? where modelo= ? and cor= ? ");
            stmt.setInt(1, a.getQnt() + a.getQntadd());
            stmt.setString(2, a.getModelo());
            stmt.setString(3, a.getCor());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void qntdeaRefil(RefilEnt r) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("select qnt FROM estoquerefis where modelo = ? ");
            stmt.setString(1, r.getModelo());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                r.setQnt(resultado.getInt("qnt"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraEstoqueRefil(RefilEnt r) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoquerefis SET qnt = ? where modelo= ? ");
            stmt.setInt(1, r.getQnt() + r.getQntadd());
            stmt.setString(2, r.getModelo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    
    public void qntdePecas(PecasEnt p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("select qnt FROM estoquepecas where nome = ? ");
            stmt.setString(1, p.getNome());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                p.setQnt(resultado.getInt("qnt"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    
    
    
     public void cadastraEstoquePecas(PecasEnt p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoquepecas SET qnt = ? where nome= ? ");
            stmt.setInt(1, p.getQnt() + p.getQntadd());
            stmt.setString(2, p.getNome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
