/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ControlaVenda;
import Control.Entidades.PurificadorEnt;
import Control.Entidades.PecasEnt;
import Control.Entidades.RefilEnt;
import Control.Entidades.VendaEnt;
import View.Venda.VendaPt2;

/**
 *
 * @author julio
 */
public class ManipulaVenda {

    VendaPt2 ven = new VendaPt2();

    public void avista(VendaEnt v, PurificadorEnt a, RefilEnt r, PecasEnt p) {

        ControlaVenda c = new ControlaVenda();

        c.verificavazioPt2(v);
    }

}
