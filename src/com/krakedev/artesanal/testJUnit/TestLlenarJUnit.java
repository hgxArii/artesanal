package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

    @Test
    public void testLlenarMaquina() {

        // CASO 1:
        // La máquina tiene una capacidad de 8000 ml.
        // Al llenarla deben quedar 7800 ml.

        Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, "M001");

        rubia.llenarMaquina();

        assertEquals(7800, rubia.getCantidadActual(), 0.0001);

    }

}

