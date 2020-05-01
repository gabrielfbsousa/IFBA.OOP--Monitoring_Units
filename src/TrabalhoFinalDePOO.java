
import Control.ControladorDePerturbacoes;
import Model.AreaMonitorada;
import Model.HorizontalEVertical;
import Model.Termometro;
import Model.UnidadeDeMonitoramento;
import Control.ControladorDeUnidades;
import Control.ViewControler;
import Model.Posicao;
import View.Posicoes5x5;
import View.TelaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class TrabalhoFinalDePOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        AreaMonitorada area = new AreaMonitorada(5, 5);
        ControladorDeUnidades controladorUnidades = new ControladorDeUnidades(area);
        ControladorDePerturbacoes controladorPerturbacoes = new ControladorDePerturbacoes(area);
        ViewControler viewControler = new ViewControler(controladorUnidades, controladorPerturbacoes);
    }

}
