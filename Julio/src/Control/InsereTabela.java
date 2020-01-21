/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.Entidades.PurificadorEnt;
import Control.Entidades.ClienteEnt;
import Control.Entidades.FuncionarioEnt;
import Control.Entidades.PecasEnt;
import Control.Entidades.RefilEnt;
import Control.Entidades.VendaEnt;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Julio
 */
public class InsereTabela {
    
    
    public void insereTabP(JTable tab, PurificadorEnt a,ClienteEnt c,FuncionarioEnt f,RefilEnt r,PecasEnt p,VendaEnt v){
         DefaultTableModel val = (DefaultTableModel) tab.getModel();
            val.addRow(new String[]{a.getModelo(),a.getCor(),f.getNome(),c.getNome(),c.getCidade(),Float.toString(a.getPreco()) });
    }
    
}
