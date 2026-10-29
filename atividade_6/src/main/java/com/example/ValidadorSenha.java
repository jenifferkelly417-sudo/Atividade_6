package com.example;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public static ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        int quantidadeDigitos = 0;
        boolean temMaiuscula = false;

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isDigit(caractere)) {
                quantidadeDigitos++;
            }

            if (Character.isUpperCase(caractere)) {
                temMaiuscula = true;
            }
        }

        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        if (!temMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}