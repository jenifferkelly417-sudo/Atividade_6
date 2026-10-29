package com.example;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public static ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        validarTamanho(senha, erros);
        validarDigitos(senha, erros);
        validarMaiuscula(senha, erros);
        validarCaractereEspecial(senha, erros);

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }

    private static void validarTamanho(
            String senha, List<String> erros) {

        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }
    }

    private static void validarDigitos(
            String senha, List<String> erros) {

        int quantidade = 0;

        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                quantidade++;
            }
        }

        if (quantidade < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }
    }

    private static void validarMaiuscula(
            String senha, List<String> erros) {

        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                return;
            }
        }

        erros.add("A senha deve conter pelo menos uma letra maiuscula");
    }

    private static void validarCaractereEspecial(
            String senha, List<String> erros) {

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (!Character.isLetterOrDigit(caractere)) {
                return;
            }
        }

        erros.add("A senha deve conter pelo menos um caractere especial");
    }
}