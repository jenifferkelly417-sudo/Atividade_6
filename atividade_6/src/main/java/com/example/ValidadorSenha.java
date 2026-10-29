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

        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                quantidadeDigitos++;
            }
        }

        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}