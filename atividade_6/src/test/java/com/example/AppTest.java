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
}