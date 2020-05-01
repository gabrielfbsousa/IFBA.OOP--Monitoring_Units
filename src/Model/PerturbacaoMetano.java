/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.ImagemPerturbacao;

/**
 *
 * @author gabriel
 */
public class PerturbacaoMetano implements TipoDaPerturbacao {

    @Override
    public ImagemPerturbacao configurarImagemDaPerturbacao(ImagemPerturbacao panel) {
        javax.swing.ImageIcon img = new javax.swing.ImageIcon("./src/res/pert_metano.png");
        //imagemDoSensor.setBackground(new Color(0, 0, 0, 64));

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);

        return panel;
    }

    @Override
    public String nomeDoTipo() {
        return "Metano";
    }

}
