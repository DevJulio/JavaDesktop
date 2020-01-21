/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ConnectionFactory;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.ClienteEnt;
import Control.Entidades.FuncionarioEnt;
import Control.Entidades.PecasEnt;
import Control.Entidades.RefilEnt;
import View.cadastro.edicao.CadastroPurificador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class InsereDados {

    public void cadastraAparelho(PurificadorEnt a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO purificadores (cor,modelo,voltagem,preco)VALUES(?,?,?,?)");
            stmt.setString(1, a.getCor());
            stmt.setString(2, a.getModelo());
            stmt.setString(3, a.getVoltagem());
            stmt.setFloat(4, a.getPreco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraAparelhoEstoque(PurificadorEnt a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoquepurificador (cor,modelo,qnt)VALUES(?,?,?)");
            stmt.setString(1, a.getCor());
            stmt.setString(2, a.getModelo());
            stmt.setInt(3, 0);

            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraRefis(RefilEnt r) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO refis (modelo,preco)VALUES(?,?)");
            stmt.setString(1, r.getModelo());
            stmt.setFloat(2, r.getPreco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraRefisEstoque(RefilEnt r) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoquerefis(modelo,qnt)VALUES(?,?)");

            stmt.setString(1, r.getModelo());
            stmt.setInt(2, 0);
            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraPecas(PecasEnt p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pecas (nome,descricao,preco)VALUES(?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraPecasEstoque(PecasEnt p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoquepecas(nome,qnt)VALUES(?,?)");

            stmt.setString(1, p.getNome());
            stmt.setInt(2, 0);
            stmt.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraClientes(ClienteEnt c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome,cpf,rua,bairro,telefone,cidade,numero,datadetroca)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getRua());
            stmt.setString(4, c.getBairro());
            stmt.setString(5, c.getTelefone());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getNumero());
            stmt.setString(8, c.getData());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void cadastraFuncionarios(FuncionarioEnt f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (nome,cargo,salario)VALUES(?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCargo());
            stmt.setFloat(3, f.getSalario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
