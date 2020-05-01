package Model;


import View.UnidadeDeMonitoramentoImagem;
import java.awt.Color;
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
public class MedidorDeMetano implements EquipamentoDeSensoriamento {

    private JPanel imagemDoSensor;

    @Override
    public UnidadeDeMonitoramentoImagem configurarImagemDoRobo(UnidadeDeMonitoramentoImagem panel) {
        imagemDoSensor = new JPanel();
        javax.swing.ImageIcon img = new javax.swing.ImageIcon("./src/res/metano.png");
        imagemDoSensor.setBackground(new Color(0, 0, 0, 64));

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
