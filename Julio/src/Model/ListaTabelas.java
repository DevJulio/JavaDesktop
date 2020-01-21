/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ControlaVenda;
import Control.Entidades.ClienteEnt;
import Control.Entidades.PecasEnt;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.RefilEnt;
import Control.Entidades.VendaEnt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class ListaTabelas {

    public List<ClienteEnt> getClientes() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ClienteEnt> Cli = new ArrayList<ClienteEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `cliente");
            rs = pstm.executeQuery();
            while (rs.next()) {

                ClienteEnt contato = new ClienteEnt();

                contato.setNome(rs.getString("nome"));
                contato.setCidade(rs.getString("Cidade"));
                contato.setBairro(rs.getString("bairro"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setRua(rs.getString("rua"));
                contato.setNumero(rs.getString("numero"));

                Cli.add(contato);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Cli;
    }

    public List<PurificadorEnt> getPurificadores() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<PurificadorEnt> Puri = new ArrayList<PurificadorEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `purificadores`");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PurificadorEnt p = new PurificadorEnt();

                p.setModelo(rs.getString("modelo"));
                p.setCor(rs.getString("cor"));
                p.setPreco(rs.getFloat("preco"));

                Puri.add(p);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Puri;
    }

    public List<RefilEnt> getRefis() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<RefilEnt> ref = new ArrayList<RefilEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `refis`");
            rs = pstm.executeQuery();
            while (rs.next()) {

                RefilEnt r = new RefilEnt();

                r.setModelo(rs.getString("modelo"));
                r.setPreco(rs.getFloat("preco"));

                ref.add(r);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return ref;
    }

    public List<PecasEnt> getPecas() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<PecasEnt> pec = new ArrayList<PecasEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `pecas`");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PecasEnt p = new PecasEnt();

                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));

                pec.add(p);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return pec;
    }

    public List<VendaEnt> getLista() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendaprimaria");
            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt venda = new VendaEnt();

                venda.setProduto(rs.getString("produto"));
                venda.setVendedor(rs.getString("vendedor"));
                venda.setPreco(rs.getFloat("preco"));
                venda.setQnt(rs.getInt("qnt"));
                venda.setValorVenda(rs.getFloat("ValorTotalVenda"));
                venda.setMetodo(rs.getString("MetodoDePagamento"));
                venda.setParcelasQnt(rs.getInt("ParcelasQnt"));
                venda.setValorParcela(rs.getFloat("ValorParcela"));
                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    public List<VendaEnt> getListaHoje() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ControlaVenda c = new ControlaVenda();
        VendaEnt venda = new VendaEnt();
        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendafinal` WHERE DataCompra=? ");
            pstm.setString(1, c.DataCompleta());

            rs = pstm.executeQuery();
            while (rs.next()) {

                venda.setProduto(rs.getString("produto"));
                venda.setCliente(rs.getString("Cliente"));
                venda.setPreco(rs.getFloat("preco"));
                venda.setQnt(rs.getInt("qnt"));
                venda.setValorVenda(rs.getFloat("ValorTotalVenda"));
                venda.setMetodo(rs.getString("MetodoDePagamento"));
                venda.setParcelasQnt(rs.getInt("ParcelasQnt"));
                venda.setValorParcela(rs.getFloat("ValorParcela"));
                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    public List<VendaEnt> getListaTodasVendas() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendafinal");
            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt venda = new VendaEnt();

                venda.setProduto(rs.getString("produto"));
                venda.setVendedor(rs.getString("vendedor"));
                venda.setPreco(rs.getFloat("preco"));
                venda.setQnt(rs.getInt("qnt"));
                venda.setValorVenda(rs.getFloat("ValorTotalVenda"));
                venda.setMetodo(rs.getString("MetodoDePagamento"));
                venda.setParcelasQnt(rs.getInt("ParcelasQnt"));
                venda.setValorParcela(rs.getFloat("ValorParcela"));
                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    public List<VendaEnt> getListaSimples(String dataPesquisa) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendafinal` WHERE DataCompra LIKE ? ");
            pstm.setString(1, "%" + dataPesquisa + "%");

            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt venda = new VendaEnt();

                venda.setProduto(rs.getString("produto"));
                venda.setCliente(rs.getString("Cliente"));
                venda.setPreco(rs.getFloat("preco"));
                venda.setQnt(rs.getInt("qnt"));
                venda.setValorVenda(rs.getFloat("ValorTotalVenda"));
                venda.setMetodo(rs.getString("MetodoDePagamento"));
                venda.setParcelasQnt(rs.getInt("ParcelasQnt"));
                venda.setValorParcela(rs.getFloat("ValorParcela"));
                venda.setData(rs.getString("DataCompra"));
                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    public List<VendaEnt> getListaComposta(int c, int d) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        VendaEnt v = new VendaEnt();
        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendafinal` WHERE DataCodigo  BETWEEN   ? AND  ? ");
            pstm.setInt(1, c);
            pstm.setInt(2, d);
            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt venda = new VendaEnt();

                venda.setProduto(rs.getString("produto"));
                venda.setCliente(rs.getString("Cliente"));
                venda.setPreco(rs.getFloat("preco"));
                venda.setQnt(rs.getInt("qnt"));
                venda.setValorVenda(rs.getFloat("ValorTotalVenda"));
                venda.setMetodo(rs.getString("MetodoDePagamento"));
                venda.setParcelasQnt(rs.getInt("ParcelasQnt"));
                venda.setValorParcela(rs.getFloat("ValorParcela"));
                venda.setData(rs.getString("DataCompra"));
                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    //////////////////////////////////TABELA PRINCIPAL/////////////////////////////////////////
    public List<VendaEnt> getListaContatoClientes() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ControlaVenda c = new ControlaVenda();

        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendafinal` WHERE DataContato = ? AND Cidade = ?");
            pstm.setString(1, c.DataCompleta());
            pstm.setString(2, "Iporá");
            System.out.println(c.DataCompleta());

            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt venda = new VendaEnt();
                venda.setCliente(rs.getString("Cliente"));
                venda.setProduto(rs.getString("produto"));
                venda.setTelefone(rs.getString("Telefone"));
                venda.setEndereco(rs.getString("Endereco"));

                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    public List<VendaEnt> getListaContatoClientesOutrasCidades() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ControlaVenda c = new ControlaVenda();

        ArrayList<VendaEnt> ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `vendafinal` WHERE DataContato = ? AND Cidade != ?");
            pstm.setString(1, c.DataCompleta());
            pstm.setString(2, "Iporá");
            System.out.println(c.DataCompleta());

            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt venda = new VendaEnt();
                venda.setCliente(rs.getString("Cliente"));
                venda.setProduto(rs.getString("produto"));
                venda.setTelefone(rs.getString("Telefone"));
                venda.setEndereco(rs.getString("Endereco"));
                venda.setCidade(rs.getString("Cidade"));

                ven.add(venda);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }
        return ven;
    }

    ////////////////pesquisa///////////
    public List<ClienteEnt> getPesquisaClientes(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ClienteEnt> Cli = new ArrayList<ClienteEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `cliente` WHERE nome LIKE ?");
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {

                ClienteEnt contato = new ClienteEnt();

                contato.setNome(rs.getString("nome"));
                contato.setRua(rs.getString("rua"));
                contato.setBairro(rs.getString("bairro"));
                contato.setTelefone(rs.getString("telefone"));

                Cli.add(contato);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Cli;
    }

    public List<PurificadorEnt> getPesquisaPurificadores(String modelo) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<PurificadorEnt> Puri = new ArrayList<PurificadorEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `purificadores` WHERE modelo LIKE ?");
            pstm.setString(1, "%" + modelo + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PurificadorEnt p = new PurificadorEnt();

                p.setModelo(rs.getString("modelo"));
                p.setCor(rs.getString("cor"));
                p.setPreco(rs.getFloat("preco"));

                Puri.add(p);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar purificadores" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Puri;
    }

    public List<RefilEnt> getPesquisaRefis(String modelo) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<RefilEnt> ref = new ArrayList<RefilEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `refis` WHERE modelo LIKE ?");
            pstm.setString(1, "%" + modelo + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {

                RefilEnt r = new RefilEnt();

                r.setModelo(rs.getString("modelo"));
                r.setPreco(rs.getFloat("preco"));

                ref.add(r);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return ref;
    }

    public List<PecasEnt> getPesquisaPecas(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<PecasEnt> pec = new ArrayList<PecasEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `pecas` WHERE nome LIKE ?");
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PecasEnt p = new PecasEnt();

                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));

                pec.add(p);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return pec;
    }

    ///////////////estoque baixo////////////////////
    public List<PurificadorEnt> getPurificadoresBaixo() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<PurificadorEnt> Puri = new ArrayList<PurificadorEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `estoquepurificador` WHERE qnt < 2");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PurificadorEnt p = new PurificadorEnt();

                p.setModelo(rs.getString("modelo"));
                p.setCor(rs.getString("cor"));
                p.setQnt(rs.getInt("qnt"));

                Puri.add(p);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Puri;
    }

    public List<RefilEnt> getRefisBaixo() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<RefilEnt> ref = new ArrayList<RefilEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `estoquerefis` WHERE qnt < 15");
            rs = pstm.executeQuery();
            while (rs.next()) {

                RefilEnt r = new RefilEnt();

                r.setModelo(rs.getString("modelo"));
                r.setQnt(rs.getInt("qnt"));

                ref.add(r);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return ref;
    }

    public List<PecasEnt> getPecasBaixo() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<PecasEnt> pec = new ArrayList<PecasEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `estoquepecas` WHERE qnt < 5");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PecasEnt p = new PecasEnt();

                p.setNome(rs.getString("nome"));
                p.setQnt(rs.getInt("qnt"));

                pec.add(p);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return pec;
    }

    //////////////////////////////estoque crítico///////////////////////
    public int QntdeResgistros() {
        int quantidade = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT COUNT('produto') FROM vendafinal");

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {

                quantidade = (resultado.getInt("COUNT('produto')"));
            }

            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return quantidade;
    }

    public List<VendaEnt> getPurificadoresCritico() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VendaEnt> Ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `estoquepurificador`");
            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt v = new VendaEnt();

                v.setProduto("Purificador " + rs.getString("modelo") + " " + rs.getString("cor"));

                Ven.add(v);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Ven;
    }

    public List<VendaEnt> getRefisCritico() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VendaEnt> Ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `estoquerefis`");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PurificadorEnt p = new PurificadorEnt();
                VendaEnt v = new VendaEnt();

                v.setProduto("Refil " + rs.getString("modelo"));

                Ven.add(v);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Ven;
    }

    public List<VendaEnt> getPecasCritico() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VendaEnt> Ven = new ArrayList<VendaEnt>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM `estoquepecas`");
            rs = pstm.executeQuery();
            while (rs.next()) {

                PurificadorEnt p = new PurificadorEnt();
                VendaEnt v = new VendaEnt();

                v.setProduto("Peça " + rs.getString("nome"));

                Ven.add(v);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }

        return Ven;
    }

////////////////////////////////////////
    public List<VendaEnt> getEstoqueCriticoPurificador(String Produto, int DataCodigo1, int DataCodigo2) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VendaEnt> Ven = new ArrayList<VendaEnt>();

        System.err.println("\n" + Produto + " Primeira data: " + DataCodigo1 + " Segunda data: " + DataCodigo2 + "\n");

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT SUM(qnt) AS tudo FROM `vendafinal` WHERE produto = ? AND  `DataCodigo` BETWEEN ? AND  ? ");
            pstm.setString(1, Produto);
            pstm.setInt(2, DataCodigo1);
            pstm.setInt(3, DataCodigo2);

            rs = pstm.executeQuery();
            while (rs.next()) {

                VendaEnt v = new VendaEnt();
                //
                v.setProduto(Produto);                                                                                                          //
                v.setQnt(rs.getInt("tudo"));                                                                                                    //
                //   
                Ven.add(v);                                                                                                                     //                                             //
            }                                                                                                                                   //
            ConnectionFactory.closeConnection(conn, pstm, rs);                                                                                  //
        } catch (Exception e) {                                                                                                                 //
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());                                                    //
        } finally {                                                                                                                             //
            ConnectionFactory.closeConnection(conn, pstm, rs);                                                                                  //
        }                                                                                                                                       //
        //
        return Ven;                                                                                                                             //
    }                                                                                                                                           //
    //  
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
