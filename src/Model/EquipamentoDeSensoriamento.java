package Model;


import View.UnidadeDeMonitoramentoImagem;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GabrielFerreira
 */
public interface EquipamentoDeSensoriamento {
    
    public abstract UnidadeDeMonitoramentoImagem configurarImagemDoRobo(UnidadeDeMonitoramentoImagem panel);
    public abstract String nomeDoTipo();
    
}
