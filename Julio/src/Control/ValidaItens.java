/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.Entidades.PurificadorEnt;
import Control.Entidades.FuncionarioEnt;
import Control.Entidades.VendaEnt;
import Model.CadastraDetalhes;
import Model.InsereDados;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class ValidaItens {

    InsereDados i = new InsereDados();
    CadastraDetalhes c = new CadastraDetalhes();

    public void validaAparelho(PurificadorEnt a) {

        if (a.getCor().equals("Selecione...") || a.getModelo().equals("Selecione...") || a.getVoltagem().equals("Selecione...") || a.getPreco() == 0) {
            JOptionPane.showConfirmDialog(null, "Verifique os campos e tente novamente");
        } else {

            i.cadastraAparelho(a);
            i.cadastraAparelhoEstoque(a);
        }

    }

    /*
    public void validaCliente(Cliente c) {
        if () {

        } else {

        }
    }
     */
    public void validaFuncionario(FuncionarioEnt f) {
        if (f.getNome().isEmpty() || f.getSalario() == 0) {
            JOptionPane.showConfirmDialog(null, "Verifique os campos e tente novamente");
        } else {
            i.cadastraFuncionarios(f);
        }
    }

    /*
    public void validaPecas(Pecas p) {
        if () {

        } else {

        }
    }

    public void validaRefil(Refil r) {
        if () {

        } else {

        }
    }
     */
    public int capturaultimodia(int mesC2, int anoC2) {
        int ultimodia = 0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, mesC2 - 1);
        c.set(Calendar.YEAR, anoC2);
        ultimodia = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        return ultimodia;

    }
///////////////////////////////////////////////
    public int capturaultimodiaEstoqueCritico() {
        int ultimodia = 0;

        Calendar c = Calendar.getInstance();
        String mes = (new SimpleDateFormat("MM").format(c.getTime()));
        int mesInt = Integer.parseInt(mes);
        c.set(Calendar.MONTH, c.get(mesInt-1));
        ultimodia = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        return ultimodia;

    }
/////////////////////////////////////////////////////////////

    public int ultimodiaCritico() {

        Date data = new Date();
        GregorianCalendar dataCal = new GregorianCalendar();
        dataCal.setTime(data);
        String mesString = "";
        
        int mes = dataCal.get(Calendar.MONTH);
        int ano = dataCal.get(Calendar.YEAR);
        int dia = capturaultimodiaEstoqueCritico();

        String aux = (mes) + "" + dia + "" + ano;
        int dt = Integer.parseInt(aux);

        return dt;
    }
/////////////////////////////////////////

    public int capturaPrimeirodiaEstoqueCritico() {
        int ultimodia = 0;

        String mes = "";
        String ano = "";
        String datacompleta = "";

        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        c.set(Calendar.YEAR, c.get(Calendar.YEAR));

        mes = (new SimpleDateFormat("MM").format(c.getTime()));
        ano = (new SimpleDateFormat("yyyy").format(c.getTime()));
        datacompleta = mes + "01" + "" + ano;

        ultimodia = Integer.parseInt(datacompleta);
        return ultimodia;

    }

    public boolean validaData(String dataPesquisaComposta1, String dataPesquisaComposta2) throws ParseException {
        int valor = 0;
        boolean var = true;
        VendaEnt v = new VendaEnt();
        Date a, b;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        a = dateFormat.parse(dataPesquisaComposta1);
        b = dateFormat.parse(dataPesquisaComposta2);
        v.setDt1(a);
        v.setDt2(b);
        valor = a.compareTo(b);

        if (valor < 0) {
            var = true;
        } else if (valor > 0) {
            var = false;
        }

        return var;
    }

}
