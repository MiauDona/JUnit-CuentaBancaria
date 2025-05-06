package miau.dona;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {
    CuentaBancaria cuentaBancaria;
    int operacion;

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
    void testRealizarOperacion01() {
        String banco, sucursal, cuenta, clave, orden, expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = "Se emite un " + orden.toLowerCase();
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion02() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "1000"; // "" o 3 digitos ---
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Código de banco erróneo: " + banco);

        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion03() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "99"; // "" o 3 digitos ---
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Código de banco erróneo: " + banco);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion04() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "999"; // 4 digitos, el primero mayor que 0 ---
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Código de sucursal erróneo: " + sucursal);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion05() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "12345"; // 4 digitos, el primero mayor que 0 ---
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Código de sucursal erróneo: " + sucursal);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion06() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "123456"; // Exactamente 5 digitos ---
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Código de cuenta erróneo: " + cuenta);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion07() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "1234"; // Exactamente 5 digitos ---
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Código de cuenta erróneo: " + cuenta);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion08() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c456"; // Exactamente 5 caracteres, alfanumericos ---
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Clave errónea: " + clave);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion09() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c4"; // Exactamente 5 caracteres, alfanumericos ---
        orden = "Talonario"; // "", Talonario o Movimientos

        expected = new IllegalArgumentException("Clave errónea: " + clave);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion10() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Talonarios"; // "", Talonario o Movimientos ---

        expected = new IllegalArgumentException("Orden errónea: " + orden);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion11() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = "Movimiento"; // "", Talonario o Movimientos ---

        expected = new IllegalArgumentException("Orden errónea: " + orden);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }

    @Test
    void testRealizarOperacion12() {
        String banco, sucursal, cuenta, clave, orden;
        Exception expected;

        banco = "123"; // "" o 3 digitos
        sucursal = "1234"; // 4 digitos, el primero mayor que 0
        cuenta = "12345"; // Exactamente 5 digitos
        clave = "12c45"; // Exactamente 5 caracteres, alfanumericos
        orden = " "; // "", Talonario o Movimientos ---

        expected = new IllegalArgumentException("Orden errónea: " + orden);
        baseRealizarOperacion(banco, sucursal, cuenta, clave, orden, expected);
    }
}