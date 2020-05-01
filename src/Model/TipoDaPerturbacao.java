/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.ImagemPerturbacao;
import View.UnidadeDeMonitoramentoImagem;

/**
 *
 * @author gabriel
 */
public interface TipoDaPerturbacao {
    public abstract ImagemPerturbacao configurarImagemDaPerturbacao(ImagemPerturbacao panel);
    public abstract String nomeDoTipo();
}
