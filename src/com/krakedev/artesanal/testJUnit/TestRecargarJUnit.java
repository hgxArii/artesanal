package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

    @Test
    public void testRecargaExitosa() {

        // CASO 1:
        // La máquina tiene capacidad de 8000 ml.
        // Se recargan 3000 ml.
        // La recarga debe ser exitosa y quedar 3000 ml.

        Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, "M001");

        boolean resultado = rubia.recargarCerveza(3000);

        assertTrue(resultado);
        assertEquals(3000, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testRecargaFallidaPorDesborde() {

        // CASO 2:
        // La máquina tiene capacidad de 8000 ml.
        // Primero se recargan 7000 ml.
        // Luego se intentan recargar 1000 ml adicionales.
        // Como el límite permitido es 7800 ml,
        // la segunda recarga debe fallar.
        // La cantidad actual debe mantenerse en 7000 ml.

        Maquina negra = new Maquina("Club R", "cerveza fria", 0.03, 8000, "M002");

        negra.recargarCerveza(7000);

        boolean resultado = negra.recargarCerveza(1000);

        assertFalse(resultado);
        assertEquals(7000, negra.getCantidadActual(), 0.0001);

    }

}

