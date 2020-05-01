/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Posicoes5x5;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class CorrespondenciaPosicao {

    private Posicao posicao;
    private Posicoes5x5 painel;

    public CorrespondenciaPosicao(Posicao posicao, Posicoes5x5 painel) {
        this.posicao = posicao;
        this.painel = painel;
        corresponder();
    }

    public JPanel corresponder() {
        JPanel aux = null;
        switch (posicao.getLinha()) {
            case 1:
                switch (posicao.getColuna()) {
                    case 1:
                        aux = painel.getjPanel1();
                        break;
                    case 2:
                        aux = painel.getjPanel2();
                        break;
                    case 3:
                        aux = painel.getjPanel3();
                        break;
                    case 4:
                        aux = painel.getjPanel4();
                        break;
                    case 5:
                        aux = painel.getjPanel5();
                        break;
                }
                ;
                break;

            case 2:
                switch (posicao.getColuna()) {
                    case 1:
                        aux = painel.getjPanel6();
                        break;
                    case 2:
                        aux = painel.getjPanel7();
                        break;
                    case 3:
                        aux = painel.getjPanel8();
                        break;
                    case 4:
                        aux = painel.getjPanel9();
                        break;
                    case 5:
                        aux = painel.getjPanel10();
                        break;
                }
                ;
                break;

            case 3:
                switch (posicao.getColuna()) {
                    case 1:
                        aux = painel.getjPanel11();
                        break;
                    case 2:
                        aux = painel.getjPanel12();
                        break;
                    case 3:
                        aux = painel.getjPanel13();
                        break;
                    case 4:
                        aux = painel.getjPanel14();
                        break;
                    case 5:
                        aux = painel.getjPanel15();
                        break;
                }
                ;
                break;

            case 4:
                switch (posicao.getColuna()) {
                    case 1:
                        aux = painel.getjPanel16();
                        break;
                    case 2:
                        aux = painel.getjPanel17();
                        break;
                    case 3:
                        aux = painel.getjPanel18();
                        break;
                    case 4:
                        aux = painel.getjPanel19();
                        break;
                    case 5:
                        aux = painel.getjPanel20();
                        break;
                }
                ;
                break;
                
                 case 5:
                switch (posicao.getColuna()) {
                    case 1:
                        aux = painel.getjPanel21();
                        break;
                    case 2:
                        aux = painel.getjPanel22();
                        break;
                    case 3:
                        aux = painel.getjPanel23();
                        break;
                    case 4:
                        aux = painel.getjPanel24();
                        break;
                    case 5:
                        aux = painel.getjPanel25();
                        break;
                }
                ;
                break;
        }
        return aux;

    }
}
