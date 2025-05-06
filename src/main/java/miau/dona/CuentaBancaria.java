package miau.dona;

public class CuentaBancaria {
    //// atributos de la clase ( no se incluyen para simplificar
    /* aquí irían todos atributos de la cuenta bancaria: numero de cuenta, banco
       suculsal, saldo, últimos movimientos, emisión de talonarios, etc.  */

    /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Este método permite al usuario realizar una consulta y obtener un talonario y/o un listado de movimientos
     *
     * @param banco Código del banco: En blanco o número de tres dígitos. En este último caso, el primero de los tiene que ser mayor que 1.
     * @param sucursal  Código de sucursal: Un número de cuatro dígitos. El primero de ellos mayor de 0.
     * @param cuenta Número de cuenta: Valor numérico de exactamente cinco dígitos.
     * @param clave Clave personal: Valor alfanumérico de exactamente cinco posiciones.
     * @param orden Orden: Este valor se introducirá según la orden que se desee realizar. Puede estar en blanco o ser una de las dos cadenas siguientes:
     *                      o “Talonario” : el usuario recibirá un talonario de cheques
     *                      o “Movimientos” : el usuario recibirá los movimientos del mes en curso
     *                      o “ ” : Si este código está en blanco, el usuario recibirá los dos documentos.
     * @return Se devuelve mediante una cadena el resultado según la orden indicada
     * @throws IllegalArgumentException  Si algún argumento no es correcto se lanzará una excepción de argumento inválido junto con un mensaje explicativo
     */




    public String realizarOperacion(String banco, String sucursal, String cuenta, String clave, String orden) throws IllegalArgumentException {
        int codBanco; // variable temporal de tipo entero para el código de banco
        int codSucursal; // variable temporal de tipo entero para el código de sucursal
        int codCuenta; // variable temporal de tipo entero para el código de cuenta

        if (banco.equals("") || banco.length() == 3) {
            try {
                codBanco = Integer.parseInt(banco);

                if (codBanco < 100 && codBanco > 999) // valor fuera de rango
                {
                    throw new IllegalArgumentException("Código de banco erróneo: " + banco);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Código de banco erróneo: " + banco);
            }
        }

        try {
            codSucursal = Integer.parseInt(sucursal);

            if (codSucursal < 1000 && codSucursal > 9999) { // valor fuera de rango
                throw new IllegalArgumentException("Código de sucursal erróneo: " + sucursal);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Código de sucursal erróneo: " + sucursal);
        }

        try {
            codCuenta = Integer.parseInt(cuenta);

            if (codCuenta < 10000 && codCuenta > 99999) { // valor fuera de rango de 5 dígitos
                throw new IllegalArgumentException("Código de cuenta erróneo: " + cuenta);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Código de cuenta erróneo: " + cuenta);
        }

        if (clave.length() != 5) {
            // si la clave no tiene exactamente 5 dígitos cualquiera
            // lanzamos excepción de argumentos no válidos con un mensaje
            throw new IllegalArgumentException("Clave errónea: " + clave);
        }

        String msg="";

        /// analizamos la orden (3 posibles valores cerrados)
        switch (orden) {

            // en cada caso, se harían las operaciones necesarias (listar movimientos buscando en base de datos, lanzar la generación de un cheque, etc
            // para simplificar el ejemplo el resultado de cada caso es un simple mensaje

            case "":
                msg = "Se envian los movimientos de la cuenta y además se emite un talonario";
                break;
            case "Movimientos":
                msg = "Se envian los movimientos de la cuenta";
                break;

            case "Talonario":
                msg = "Se emite un talonario";
                break;

            default:
                // si no es uno de los valores cerrados
                // lanzamos excepción de argumentos no válidos con un mensaje
                throw new IllegalArgumentException("Orden errónea: " + orden);
        }

        return msg;  // el usuario obtiene respuesta
    }
}
