/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.ImagemPerturbacao;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class Perturbacao {
    private Posicao posicaoAtual;
    private ImagemPerturbacao imagemDaPerturbacao;
    private TipoDaPerturbacao tipo;
    
    public Perturbacao(Posicao posicao){
        posicaoAtual = posicao;
        imagemDaPerturbacao = new ImagemPerturbacao();
        imagemDaPerturbacao.setBackground(new Color(0, 0, 0, 64));
    }
    
    public void setTipo(TipoDaPerturbacao tipo){
        this.tipo = tipo;
        imagemDaPerturbacao = tipo.configurarImagemDaPerturbacao(imagemDaPerturbacao);
    }

    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }

    public ImagemPerturbacao getImagemDaPerturbacao() {
        return imagemDaPerturbacao;
    }

    public TipoDaPerturbacao getTipoDaPerturbacao() {
        return tipo;
    }
    
    
}
