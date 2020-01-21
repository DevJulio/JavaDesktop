/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.Entidades.ClienteEnt;
import Control.Entidades.FuncionarioEnt;
import Control.Entidades.PecasEnt;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.RefilEnt;
import Control.Entidades.VendaEnt;
import Model.Venda.InsereBancoPrimario;
import Model.Venda.InsereBancoPrimarioPt2;
import Model.Venda.Manipulacao;
import Model.Venda.MatematicaModel;
import View.Venda.VendaPt2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class ControlaVenda {

    InsereBancoPrimario i = new InsereBancoPrimario();
    Manipulacao mn = new Manipulacao();
    VendaPt2 ven = new VendaPt2();
    MatematicaModel m = new MatematicaModel();
    float aux = 0;
    String vendedor;
    int Qnt;
    String ProdutoControle;
    VendaEnt ve = new VendaEnt();

    public String prod(PecasEnt p, PurificadorEnt pu, RefilEnt r, VendaEnt v, FuncionarioEnt f, ClienteEnt c) {

        String produto = "";

        v.setData(DataCompleta());
        v.setDataContato(DataDeContato());
        v.setCodigoData(GeraCodigo());

        switch (v.getCod()) {
            case 1:
                v.setProduto("Purificador" + " " + pu.getModelo() + " " + pu.getCor());
                v.setVendedor(f.getNome());
                v.setPreco(pu.getPreco() * pu.getQnt());
                v.setQnt(pu.getQnt());
                v.setQntExistente(Qnt);
                aux = v.getPreco();
                verificavazio(v);

                break;
            case 2:
                v.setProduto("Refil" + " " + r.getModelo());
                v.setVendedor(f.getNome() + " " + f.getCargo());
                v.setPreco(r.getPreco() * r.getQnt());
                v.setQnt(r.getQnt());
                aux = v.getPreco();
                verificavazio(v);
                break;
            case 3:
                v.setProduto("Peça" + " " + p.getNome() + " " + p.getDescricao());
                v.setVendedor(f.getNome() + " " + f.getCargo());
                v.setPreco(p.getPreco() * p.getQnt());
                v.setQnt(p.getQnt());
                aux = v.getPreco();
                verificavazio(v);
                break;
            default:
                break;
        }

        vendedor = v.getVendedor();
        Qnt = v.getQnt();
        ProdutoControle = v.getProduto();

        //  System.out.println(ProdutoControle + " fon");
        return produto;

    }

    public void verificavazio(VendaEnt v) {

        if ("".equals(v.getVendedor()) || v.getQnt() == 0 || v.getProduto() == " ") {

            JOptionPane.showMessageDialog(null, "Verifque os dados e tente novamente");

        } else {

            v.setVerifica(true);
            atualizaPrecoFinal(v);

            i.cadastraVendaPrimaria(v);
            i.cadastraTodasAsVendasPrimarias(v);

        }
    }

    public void verificavazioPt2(VendaEnt v) {

        System.out.print(v.getVerifica());

        if (v.getVerifica()) {

            ven.setVisible(true);

        }

    }

    public void atualizaPrecoFinal(VendaEnt v) {

        v.setValorVenda(v.getValorVenda() + aux);

    }

    public void Manipula(String MetodoDaVenda, float QntParcelas) {

        String Metodo = MetodoDaVenda;
        float QuantidadeDeParcelas = QntParcelas;
        //String metodo;
        float parcela;
        InsereBancoPrimarioPt2 i = new InsereBancoPrimarioPt2();

        switch (Metodo) {
            case "A Vista":
                //metodo = "A vista";
                parcela = m.soma();
                i.atualizaCompraMetodoDePagamento("A Vista");
                i.atualizaCompraParcelasQnt(1);
                i.atualizaCompraValorParcela(parcela);
                i.atualizaCompraValorTotalVenda(parcela);

                break;
            case "Cartão":

                parcela = m.soma() / QuantidadeDeParcelas;
                i.atualizaCompraMetodoDePagamento("Cartão");
                i.atualizaCompraParcelasQnt((int) (QuantidadeDeParcelas));
                i.atualizaCompraValorParcela(parcela);
                i.atualizaCompraValorTotalVenda(m.soma());

                break;
            case "Cheque":

                parcela = m.soma() / QuantidadeDeParcelas;
                i.atualizaCompraMetodoDePagamento("Cheque");
                i.atualizaCompraParcelasQnt((int) (QuantidadeDeParcelas));
                i.atualizaCompraValorParcela(parcela);
                i.atualizaCompraValorTotalVenda(m.soma());

                break;
            default:
                break;
        }

        ven.readJtable();
        ven.setVisible(true);

    }

    public void ManipulaCheque(VendaEnt v) {

        System.out.println(v.getCheque());//parcelas
        System.out.println(v.getMetodo());//método (cartão)
        System.out.println(m.soma() / Float.parseFloat(v.getCheque()));//valor parcela individual
        System.out.println(m.soma());//valor da compra total

        ven.setVisible(true);

    }

    public String DataCompleta() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String DataDeContato() {
        Date d = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);

        return (new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
    }

    public int GeraCodigo() {
        String cod = "";
        int aux;
        DateFormat dateFormatdd = new SimpleDateFormat("dd");
        DateFormat dateFormatMM = new SimpleDateFormat("MM");
        DateFormat dateFormatYYYY = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String dia = dateFormatdd.format(date);
        String mes = dateFormatMM.format(date);
        String ano = dateFormatYYYY.format(date);

        System.err.println(dia);
        System.err.println(mes);
        System.err.println(ano);
        cod = mes + "" + dia + "" + ano;
        aux = Integer.parseInt(cod);
        System.err.println(aux);
        return aux;

    }

    public int GeraCodigoPesquisa(int dia, int mes, int ano) {

        String diaString = "";
        int aux = 0;
        if (dia <= 9) {
            diaString = "0" + String.valueOf(dia);

        } else {
            diaString = String.valueOf(dia);
        }

        String cod = "";

        try {
            cod = Integer.toString(mes) + "" + diaString + "" + Integer.toString(ano);
            aux = Integer.parseInt(cod);
            System.err.println(aux + "esse é o código que será pesquisado no banco");
        } catch (Exception erro) {

            System.out.println(erro);

        }
        return aux;

    }

}
