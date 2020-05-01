/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.AreaMonitorada;
import Model.Perturbacao;
import Model.UnidadeDeMonitoramento;
import View.NovaPerturbacao;
import View.NovaUnidade;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ControladorDePerturbacoes {

    private ArrayList<Perturbacao> perturbacoes;
    private NovaPerturbacao painelNovaPerturbacao;
    private AreaMonitorada area;

    public ControladorDePerturbacoes(AreaMonitorada area) {
        perturbacoes = new ArrayList();
        painelNovaPerturbacao = new NovaPerturbacao();
        this.area = area;
    }

    public ArrayList<Perturbacao> getUnidades() {
        return perturbacoes;
    }

    public NovaPerturbacao getPainelNovaPerturbacao() {
        return painelNovaPerturbacao;
    }

    public AreaMonitorada getArea() {
        return area;
    }
}
