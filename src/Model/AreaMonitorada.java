package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GabrielFerreira
 */
public class AreaMonitorada {

    private int quantidadeDeLinhas;
    private int quantidadeDeColunas;
    private int[][] area;

    public AreaMonitorada(int linhas, int colunas) {
        quantidadeDeLinhas = linhas;
        quantidadeDeColunas = colunas;
        area = new int[linhas][colunas];
    }

    public int getQuantidadeDeLinhas() {
        return quantidadeDeLinhas;
    }

    public int getQuantidadeDeColunas() {
        return quantidadeDeColunas;
    }

    public int[][] getArea() {
        return area;
    }
    
    
}
