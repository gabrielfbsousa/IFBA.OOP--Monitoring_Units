package Control;


import Model.AreaMonitorada;
import Model.UnidadeDeMonitoramento;
import View.NovaUnidade;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GabrielFerreira
 */
public class ControladorDeUnidades {
    private ArrayList<UnidadeDeMonitoramento> unidades;
    private NovaUnidade painelNovaUnidade;
    private AreaMonitorada area;
    
    public ControladorDeUnidades(AreaMonitorada area){
        unidades = new ArrayList();
        painelNovaUnidade = new NovaUnidade();
        this.area = area;
    }

    public ArrayList<UnidadeDeMonitoramento> getUnidades() {
        return unidades;
    }

    public NovaUnidade getPainelNovaUnidade() {
        return painelNovaUnidade;
    }

    public AreaMonitorada getArea() {
        return area;
    }
    
    
    
    
}
