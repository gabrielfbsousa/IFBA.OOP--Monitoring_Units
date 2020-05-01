/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CorrespondenciaPosicao;
import Model.Perturbacao;
import Model.PerturbacaoCO2;
import Model.PerturbacaoCamera;
import Model.PerturbacaoMetano;
import Model.PerturbacaoTermometro;
import Model.Posicao;
import View.NovaPerturbacao;
import View.NovaUnidade;
import View.Posicoes5x5;
import View.TelaPrincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class PerturbacaoViewControler {

    private TelaPrincipal window;
    private NovaUnidade painelNovaUnidade;
    private NovaPerturbacao painelNovaPerturbacao;
    private Posicoes5x5 painel;
    private ControladorDeUnidades controladorUnidades;
    private ControladorDePerturbacoes controladorPerturbacoes;

    public PerturbacaoViewControler(ControladorDeUnidades controladorUnidades, ControladorDePerturbacoes controladorPerturbacoes, TelaPrincipal window, Posicoes5x5 painel) {
        this.controladorUnidades = controladorUnidades;
        this.controladorPerturbacoes = controladorPerturbacoes;
        this.painelNovaUnidade = controladorUnidades.getPainelNovaUnidade();
        this.painelNovaPerturbacao = controladorPerturbacoes.getPainelNovaPerturbacao();
        this.painel = painel;
        this.window = window;
    }

    public void configurarCriarPerturbacao() {
        window.getjButton2().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.add(painelNovaPerturbacao);
                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });
    }

    public void configurarPainelNovaPerturbacao(ViewControler viewController) {
        painelNovaPerturbacao.getjButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = (Integer.parseInt(painelNovaPerturbacao.getjTextField1().getText()));
                int coluna = (Integer.parseInt(painelNovaPerturbacao.getjTextField2().getText()));
                Posicao posicao = new Posicao(linha, coluna);

                CorrespondenciaPosicao correspondente = new CorrespondenciaPosicao(posicao, painel);
                JPanel painelCorrespondente = correspondente.corresponder();
                painelCorrespondente.removeAll();
                painel.adicionarImagemPadrao(painelCorrespondente);

                if (!viewController.getControladorUnidades().getUnidades().isEmpty()) {
                    for (int i = 0; i < viewController.getControladorUnidades().getUnidades().size(); i++) {
                        if (viewController.getControladorUnidades().getUnidades().get(i).getPosicaoAtual().getColuna() == posicao.getColuna()
                                && viewController.getControladorUnidades().getUnidades().get(i).getPosicaoAtual().getLinha() == posicao.getLinha()) {

                            viewController.getControladorUnidades().getUnidades().remove(i);
                        }

                    } //Se houver algum, ele remove da lista, e substitui pelo novo criado

                }

                if (!viewController.getControladorPerturbacoes().getUnidades().isEmpty()) {
                    for (int i = 0; i < viewController.getControladorPerturbacoes().getUnidades().size(); i++) {
                        if (viewController.getControladorPerturbacoes().getUnidades().get(i).getPosicaoAtual().getColuna() == posicao.getColuna()
                                && viewController.getControladorPerturbacoes().getUnidades().get(i).getPosicaoAtual().getLinha() == posicao.getLinha()) {

                            viewController.getControladorPerturbacoes().getUnidades().remove(i);
                        }

                    } //Se houver algum, ele remove da lista, e substitui pelo novo criado

                }
            
                    inserirPerturbacaoNoMapa(posicao, viewController);
                }
            
        });
    }

    public void inserirPerturbacaoNoMapa(Posicao posicao, ViewControler viewController) {
        Perturbacao perturbacao = new Perturbacao(posicao);

        String selected = painelNovaPerturbacao.getjComboBox1().getSelectedItem() + "";
        if (selected.equals("Termômetro")) {
            perturbacao.setTipo(new PerturbacaoTermometro());
        } else if (selected.equals("Câmera")) {
            perturbacao.setTipo(new PerturbacaoCamera());
        } else if (selected.equals("CO2")) {
            perturbacao.setTipo(new PerturbacaoCO2());
        } else if (selected.equals("Metano")) {
            perturbacao.setTipo(new PerturbacaoMetano());
        }

        CorrespondenciaPosicao correspondente = new CorrespondenciaPosicao(posicao, painel);

        //Armengue necessário pra rodar (sem ele, não tá rodando)
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(perturbacao.getImagemDaPerturbacao());
        frame.pack();
        frame.repaint();

        JPanel painelCorrespondente = correspondente.corresponder();
        painelCorrespondente.add(perturbacao.getImagemDaPerturbacao());

        //Adicionar o painel de volta ao panel
        window.getjPanel1().setLayout(new BorderLayout());
        window.getjPanel1().add(painel);
        //window.pack(); //O pack() ajusta a tela ao tamanho correto dos componentes
        window.repaint();

        viewController.getControladorPerturbacoes().getUnidades().add(perturbacao);
    }

}
