/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Camera;
import Model.CorrespondenciaPosicao;
import Model.HorizontalEVertical;
import Model.MedidorDeCO2;
import Model.MedidorDeMetano;
import Model.MovimentoLivre;
import Model.Perturbacao;
import Model.PerturbacaoCO2;
import Model.PerturbacaoCamera;
import Model.PerturbacaoMetano;
import Model.PerturbacaoTermometro;
import Model.Posicao;
import Model.Termometro;
import Model.UnidadeDeMonitoramento;
import View.NovaPerturbacao;
import View.NovaUnidade;
import View.Posicoes5x5;
import View.TelaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class ViewControler {

    private TelaPrincipal window;
    private NovaUnidade painelNovaUnidade;
    private NovaPerturbacao painelNovaPerturbacao;
    private Posicoes5x5 painel;
    private ControladorDeUnidades controladorUnidades;
    private ControladorDePerturbacoes controladorPerturbacoes;

    public ViewControler(ControladorDeUnidades controladorUnidades, ControladorDePerturbacoes controladorPerturbacoes) throws IOException {
        window = new TelaPrincipal();
        this.controladorUnidades = controladorUnidades;
        this.controladorPerturbacoes = controladorPerturbacoes;
        this.painelNovaUnidade = controladorUnidades.getPainelNovaUnidade();
        this.painelNovaPerturbacao = controladorPerturbacoes.getPainelNovaPerturbacao();

        window.setVisible(true);

        //criar painel e adicioná-lo
        painel = new Posicoes5x5();
        window.getjPanel1().setLayout(new BorderLayout());
        window.getjPanel1().add(painel);

        UnidadeViewControler unidadeView = new UnidadeViewControler(controladorUnidades, controladorPerturbacoes, window, painel);
        unidadeView.configurarCriarNovaUnidade();
        unidadeView.configurarPainelNovaUnidade(this);
        
        
        PerturbacaoViewControler perturbacaoView = new PerturbacaoViewControler(controladorUnidades, controladorPerturbacoes, window, painel);
        perturbacaoView.configurarCriarPerturbacao();
        perturbacaoView.configurarPainelNovaPerturbacao(this);
        
        CombateViewControler combateView = new CombateViewControler(controladorUnidades, controladorPerturbacoes, window, painel);
        combateView.configurarCombate(this);
        combateView.configurarPainelCombate(this);
        
        window.pack(); //O pack() ajusta a tela ao tamanho correto dos componentes
        window.repaint();
    }

    public ControladorDeUnidades getControladorUnidades() {
        return controladorUnidades;
    }

    public void setControladorUnidades(ControladorDeUnidades controladorUnidades) {
        this.controladorUnidades = controladorUnidades;
    }

    public ControladorDePerturbacoes getControladorPerturbacoes() {
        return controladorPerturbacoes;
    }

    public void setControladorPerturbacoes(ControladorDePerturbacoes controladorPerturbacoes) {
        this.controladorPerturbacoes = controladorPerturbacoes;
    }
    
    

}
