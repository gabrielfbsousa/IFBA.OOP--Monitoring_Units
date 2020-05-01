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
public interface Mobilidade {
    public abstract void mover(int coordenadaX, int coordenadaY);
    public abstract double calcularDistancia(int linhaAtual, int colunaAtual, int linhaNova, int colunaNova);
    public abstract UnidadeDeMonitoramentoImagem configurarImagemDoRobo(UnidadeDeMonitoramentoImagem panel);
}
