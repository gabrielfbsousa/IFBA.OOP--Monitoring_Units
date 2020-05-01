/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ControladorDePerturbacoes;
import Control.ControladorDeUnidades;

/**
 *
 * @author gabriel
 */
public class Posicao {

    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.coluna = coluna;
        this.linha = linha;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }


}
