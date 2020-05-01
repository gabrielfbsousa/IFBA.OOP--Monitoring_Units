/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CorrespondenciaPosicao;
import Model.EquipamentoDeSensoriamento;
import Model.Perturbacao;
import Model.Posicao;
import Model.UnidadeDeMonitoramento;
import View.CombaterPerturbacao;
import View.NovaPerturbacao;
import View.NovaUnidade;
import View.Posicoes5x5;
import View.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class CombateViewControler {

    private TelaPrincipal window;
    private NovaUnidade painelNovaUnidade;
    private CombaterPerturbacao painelCombate;
    private Posicoes5x5 painel;
    private ControladorDeUnidades controladorUnidades;
    private ControladorDePerturbacoes controladorPerturbacoes;

    private ArrayList<Perturbacao> perturbacoes;

    public CombateViewControler(ControladorDeUnidades controladorUnidades, ControladorDePerturbacoes controladorPerturbacoes, TelaPrincipal window, Posicoes5x5 painel) {
        this.controladorUnidades = controladorUnidades;
        this.controladorPerturbacoes = controladorPerturbacoes;
        this.painelNovaUnidade = controladorUnidades.getPainelNovaUnidade();
        this.painelCombate = new CombaterPerturbacao();
        this.painel = painel;
        this.window = window;

        perturbacoes = new ArrayList();
    }

    public void configurarCombate(ViewControler viewController) {
        window.getjButton3().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < viewController.getControladorPerturbacoes().getUnidades().size(); i++) {
                    Perturbacao auxiliar = viewController.getControladorPerturbacoes().getUnidades().get(i);
                    int linha = auxiliar.getPosicaoAtual().getLinha();
                    int coluna = auxiliar.getPosicaoAtual().getColuna();
                    painelCombate.getjComboBox1().addItem((auxiliar.getTipoDaPerturbacao().nomeDoTipo() + " - Linha " + Integer.toString(linha) + " e Coluna " + Integer.toString(coluna)));
                    perturbacoes.add(auxiliar);
                }

                JFrame frame = new JFrame();
                frame.add(painelCombate);
                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });
    }

    public void configurarPainelCombate(ViewControler viewController) {
        //Configurar botão de pesquisar a perturbação desejada
        painelCombate.getjButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = painelCombate.getjComboBox1().getSelectedIndex();
                Perturbacao perturbacao = perturbacoes.get(indice);
                DefaultListModel model = new DefaultListModel();
                
                UnidadeDeMonitoramento unidadeMaisProxima = null;
                double menorDistancia = 1000; //Um valor alto qualquer

                for (int i = 0; i < viewController.getControladorUnidades().getUnidades().size(); i++) {
                    for (int j = 0; j < viewController.getControladorUnidades().getUnidades().get(i).getEquipamentos().size(); j++) {
                        if (viewController.getControladorUnidades().getUnidades().get(i).getEquipamentos().get(j).nomeDoTipo().equals(perturbacao.getTipoDaPerturbacao().nomeDoTipo())) {
                            UnidadeDeMonitoramento aux = viewController.getControladorUnidades().getUnidades().get(i);
                            double distancia = aux.calcularDistancia(perturbacao.getPosicaoAtual().getLinha(), perturbacao.getPosicaoAtual().getColuna());
                            
                            int linha = aux.getPosicaoAtual().getLinha();
                            int coluna = aux.getPosicaoAtual().getColuna();
                            model.addElement("Unidade da Linha "+Integer.toString(linha)+" e Coluna "+Integer.toString(coluna)+ " - Distância até perturbação: "+Double.toString(distancia));
                            
                            if(distancia < menorDistancia){
                                menorDistancia = distancia;
                                unidadeMaisProxima = aux;
                            }

                        }
                    }
                }
                painelCombate.getjList1().setModel(model);
                
                //Adicionar o mais próximo ao painel 
                painelCombate.getjTextField1().setText(Integer.toString(unidadeMaisProxima.getPosicaoAtual().getLinha()));
                painelCombate.getjTextField2().setText(Integer.toString(unidadeMaisProxima.getPosicaoAtual().getColuna()));
                painelCombate.getjPanel1().add(unidadeMaisProxima.getImagemDaUnidade());
                painelCombate.revalidate();
                painelCombate.repaint();
            }
        });

    }

    public ControladorDeUnidades getControladorUnidades() {
        return controladorUnidades;
    }

    public ControladorDePerturbacoes getControladorPerturbacoes() {
        return controladorPerturbacoes;
    }

}
