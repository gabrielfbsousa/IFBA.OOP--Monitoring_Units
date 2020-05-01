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
import Model.Posicao;
import Model.Termometro;
import Model.UnidadeDeMonitoramento;
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
public class UnidadeViewControler {

    private TelaPrincipal window;
    private NovaUnidade painelNovaUnidade;
    private NovaPerturbacao painelNovaPerturbacao;
    private Posicoes5x5 painel;
    private ControladorDeUnidades controladorUnidades;
    private ControladorDePerturbacoes controladorPerturbacoes;

    public UnidadeViewControler(ControladorDeUnidades controladorUnidades, ControladorDePerturbacoes controladorPerturbacoes, TelaPrincipal window, Posicoes5x5 painel) {
        this.controladorUnidades = controladorUnidades;
        this.controladorPerturbacoes = controladorPerturbacoes;
        this.painelNovaUnidade = controladorUnidades.getPainelNovaUnidade();
        this.painelNovaPerturbacao = controladorPerturbacoes.getPainelNovaPerturbacao();
        this.painel = painel;
        this.window = window;
    }

    public void configurarCriarNovaUnidade() {
        window.getjButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.add(painelNovaUnidade);
                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });
    }

    public void configurarPainelNovaUnidade(ViewControler viewController) {
        painelNovaUnidade.getjButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = (Integer.parseInt(painelNovaUnidade.getjTextField1().getText()));
                int coluna = (Integer.parseInt(painelNovaUnidade.getjTextField2().getText()));
                Posicao posicao = new Posicao(linha, coluna);

                CorrespondenciaPosicao correspondente = new CorrespondenciaPosicao(posicao, painel);
                JPanel painelCorrespondente = correspondente.corresponder();
                painelCorrespondente.removeAll();
                painel.adicionarImagemPadrao(painelCorrespondente);

                //if(array de unidades. posição != posição dada pelo usuário)  <-- importante pq dois corpos não ocupam o msm lugar no espaço
                //Se a lista está vazia, insere logo
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
                
                inserirRoboNoMapa(posicao, viewController);
            }
        });

    }

    public void inserirRoboNoMapa(Posicao posicao, ViewControler viewController) {
        UnidadeDeMonitoramento unidade = new UnidadeDeMonitoramento(controladorUnidades.getArea());

        if (painelNovaUnidade.getjCheckBox1().isSelected()) {
            unidade.addEquipamentoDeSensoriamento(new Camera());
        }
        if (painelNovaUnidade.getjCheckBox2().isSelected()) {
            unidade.addEquipamentoDeSensoriamento(new MedidorDeCO2());
        }
        if (painelNovaUnidade.getjCheckBox3().isSelected()) {
            unidade.addEquipamentoDeSensoriamento(new Termometro());
        }
        if (painelNovaUnidade.getjCheckBox4().isSelected()) {
            unidade.addEquipamentoDeSensoriamento(new MedidorDeMetano());
        }

        //Adiciona qual o tipo de mobilidade escolhida
        String selected = painelNovaUnidade.getjComboBox1().getSelectedItem() + "";
        if (selected.equals("Horizontal e vertical")) {
            unidade.setMobilidade(new HorizontalEVertical());
        } else {
            unidade.setMobilidade(new MovimentoLivre());
        }

        //Pega qual o ponto escolhido pelo usuário para ele ser colocado 
        unidade.setPosicaoAtual(posicao);
        CorrespondenciaPosicao correspondente = new CorrespondenciaPosicao(posicao, painel);

        //Armengue necessário pra rodar (sem ele, não tá rodando)
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(unidade.getImagemDaUnidade());
        frame.pack();
        frame.repaint();

        //Pegar a posição correspondente e adicionar a imagem da unidade ao painel dela
        JPanel painelCorrespondente = correspondente.corresponder();
        painelCorrespondente.add(unidade.getImagemDaUnidade());

        //Adicionar o painel de volta ao panel
        window.getjPanel1().setLayout(new BorderLayout());
        window.getjPanel1().add(painel);
        window.pack(); //O pack() ajusta a tela ao tamanho correto dos componentes
        window.repaint();

        viewController.getControladorUnidades().getUnidades().add(unidade);
    }

    public ControladorDeUnidades getControladorUnidades() {
        return controladorUnidades;
    }

    public ControladorDePerturbacoes getControladorPerturbacoes() {
        return controladorPerturbacoes;
    }

    
}
