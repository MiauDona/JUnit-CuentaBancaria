package miau.dona;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {
    CuentaBancaria cuentaBancaria;

    @BeforeEach
    void setUp() {
        cuentaBancaria = new CuentaBancaria();
    }

    @AfterEach
    void tearDown() {
        cuentaBancaria = null;
    }

    private void baseRealizarOperacion(String banco, String sucursal, String cuenta, String clave, String orden, Object expected) {
        System.out.println("Probando operacion");

        String resultado = cuentaBancaria.realizarOperacion(banco, sucursal, cuenta, clave, orden);
        assertEquals(expected, resultado);
    }

    @Test
    void testRealizarOperacion1() {
        String banco, sucursal, cuenta, clave, orden, expected;
        banco = "Banco1"; // Debería de soltar un error pero continua
        sucursal = "123456789";
        cuenta = "123456789";
        clave = "12345";
        orden = "Talonario";
        expected = "Se emite un " + orden.toLowerCase();

        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion2() {
        String banco, sucursal, cuenta, clave, orden, expected;
        banco = "Banco1";
        sucursal = "123456789";
        cuenta = "123456789";
        clave = "12345";
        orden = "Talonario";
        expected = "Se emite un " + orden.toLowerCase();

        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }


}