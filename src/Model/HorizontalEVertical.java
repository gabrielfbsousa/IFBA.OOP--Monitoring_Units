package Model;


import View.UnidadeDeMonitoramentoImagem;
import java.awt.Color;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
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
public class HorizontalEVertical implements Mobilidade {

    @Override
    public void mover(int coordenadaX, int coordenadaY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadeDeMonitoramentoImagem configurarImagemDoRobo(UnidadeDeMonitoramentoImagem panel) {
        javax.swing.ImageIcon img = new javax.swing.ImageIcon("./src/res/horizontalevertical.png");
        //imagemDoMovimento.setBackground(new Color(0, 0, 0, 64));

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
        
        return panel;
    }

    @Override
    public double calcularDistancia(int linhaAtual, int colunaAtual, int linhaNova, int colunaNova) {
        return abs(linhaAtual - linhaNova) + abs(colunaAtual - colunaNova);
    }

}
