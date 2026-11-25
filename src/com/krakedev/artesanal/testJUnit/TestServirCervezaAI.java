package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

    @Test
    public void testCaso1ServirCantidadDisponible() {

        // CASO 1:
        // Tiene 5000 ml y solicita 2000 ml.
        // Cobra 40 y quedan 3000 ml.

        Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, "M001");

        rubia.recargarCerveza(5000);

        double valor = rubia.servirCerveza(2000);

        assertEquals(40, valor, 0.0001);
        assertEquals(3000, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testCaso2ServirTodaLaCantidadDisponible() {

        // CASO 2:
        // Tiene 5000 ml y solicita 5000 ml.
        // Cobra 100 y quedan 0 ml.

        Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, "M002");

        rubia.recargarCerveza(5000);

        double valor = rubia.servirCerveza(5000);

        assertEquals(100, valor, 0.0001);
        assertEquals(0, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testCaso3SolicitarMasCantidadDisponible() {

        // CASO 3:
        // Tiene 4000 ml y solicita 5000 ml.
        // Cobra 0 y conserva los 4000 ml.

        Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, "M003");

        rubia.recargarCerveza(4000);

        double valor = rubia.servirCerveza(5000);

        assertEquals(0, valor, 0.0001);
        assertEquals(4000, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testCaso4SegundoConstructor() {

        // CASO 4:
        // Utiliza el segundo constructor.
        // La capacidad es 10000 ml.
        // Al llenar quedan 9800 ml.
        // Solicita 2000 ml, cobra 60 y quedan 7800 ml.

        Maquina negra = new Maquina("Club", "cerveza buena", 0.03, "M004");

        negra.llenarMaquina();

        double valor = negra.servirCerveza(2000);

        assertEquals(60, valor, 0.0001);
        assertEquals(7800, negra.getCantidadActual(), 0.0001);

    }

    @Test
    public void testCaso5NoModificarCantidadCuandoNoAlcanza() {

        // CASO 5:
        // Utiliza el segundo constructor.
        // Tiene 3000 ml y solicita 4000 ml.
        // Cobra 0 y conserva los 3000 ml.

        Maquina negra = new Maquina("Club", "cerveza buena", 0.03, "M005");

        negra.recargarCerveza(3000);

        double valor = negra.servirCerveza(4000);

        assertEquals(0, valor, 0.0001);
        assertEquals(3000, negra.getCantidadActual(), 0.0001);

    }

}

