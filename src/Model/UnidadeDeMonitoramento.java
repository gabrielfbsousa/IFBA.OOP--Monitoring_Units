package Model;


import View.UnidadeDeMonitoramentoImagem;
import java.awt.Color;
import java.util.ArrayList;
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
public class UnidadeDeMonitoramento {

    private int ID;
    private ArrayList<EquipamentoDeSensoriamento> equipamentos;
    private AreaMonitorada area;
    private Mobilidade modeloDeMobilidade;
    private UnidadeDeMonitoramentoImagem imagemDaUnidade;
    private Posicao posicaoAtual;

    public UnidadeDeMonitoramento(AreaMonitorada area) {
        this.area = area;
        equipamentos = new ArrayList();
        imagemDaUnidade = new UnidadeDeMonitoramentoImagem();
        imagemDaUnidade.setBackground(new Color(0, 0, 0, 64));
    }

    public void moverAtéNovoPonto(int novaLinha, int novaColuna) {
        modeloDeMobilidade.mover(novaLinha, novaColuna);
    }
    
    public double calcularDistancia(int novaLinha, int novaColuna){
       return modeloDeMobilidade.calcularDistancia(posicaoAtual.getLinha(), posicaoAtual.getColuna(), novaLinha, novaColuna);
    }

    public void setMobilidade(Mobilidade mobilidade) {
        modeloDeMobilidade = mobilidade;
        imagemDaUnidade = modeloDeMobilidade.configurarImagemDoRobo(imagemDaUnidade);
    }

    public void addEquipamentoDeSensoriamento(EquipamentoDeSensoriamento equip) {
        imagemDaUnidade = equip.configurarImagemDoRobo(imagemDaUnidade);
        equipamentos.add(equip);
    }

    public JPanel getImagemDaUnidade() {
        return imagemDaUnidade;
    }

    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(Posicao posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public ArrayList<EquipamentoDeSensoriamento> getEquipamentos() {
        return equipamentos;
    }
    
    

}
