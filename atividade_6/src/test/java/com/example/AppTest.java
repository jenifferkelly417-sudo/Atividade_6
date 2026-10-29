package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void deveRejeitarSenhaComMenosDeOitoCaracteres() {
        ResultadoValidacao resultado =
                ValidadorSenha.validar("Ab1!");

        assertFalse(resultado.isValida());

        assertTrue(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"
        ));
    }
    @Test
    void deveRejeitarSenhaComMenosDeDoisDigitos() {
        ResultadoValidacao resultado =
                ValidadorSenha.validar("Abcdefg!");

        assertFalse(resultado.isValida());

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"
        ));
    }
    @Test
    void deveRejeitarSenhaSemLetraMaiuscula() {
        ResultadoValidacao resultado =
                ValidadorSenha.validar("abcdef12!");

        assertFalse(resultado.isValida());

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos uma letra maiuscula"
        ));
    }
}