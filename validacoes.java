package com.sgp.util;

/*Classe  para validação de dados de carro.*/
public class Validacoes {

    private Validacoes() {
        // Impede instância
    }

 /*modelo */
    public static boolean modeloValido(String modelo) {
        return modelo != null && !modelo.trim().isEmpty();
    }

    public static String mensagemErroModelo(String modelo) {
        return modeloValido(modelo) 
            ? "" 
            : "Erro: O modelo do carro não pode estar vazio!";
    }
    /*ano */

    public static boolean anoValido(int ano) {
        return ano >= 1886 && ano <= 2100;
    }

    public static String mensagemErroAno(int ano) {
        if (ano < 1886) {
            return "Erro: Ano muito antigo!";
        }
        if (ano > 2100) {
            return "Erro: Ano inválido!";
        }
        return "";
    }
/*velocidade */
    public static boolean velocidadeValida(double velocidade) {
        return velocidade >= 0 && velocidade <= 400;
    }

    public static String mensagemErroVelocidade(double velocidade) {
        if (velocidade < 0) {
            return "Erro: Velocidade não pode ser negativa!";
        }
        if (velocidade > 400) {
            return "Erro: Velocidade acima do permitido!";
        }
        return "";
    }
}