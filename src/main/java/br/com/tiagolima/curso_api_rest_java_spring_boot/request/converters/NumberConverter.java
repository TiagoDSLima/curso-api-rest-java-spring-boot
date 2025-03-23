package br.com.tiagolima.curso_api_rest_java_spring_boot.request.converters;

import br.com.tiagolima.curso_api_rest_java_spring_boot.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static double convertToDouble(String number) throws UnsupportedMathOperationException {
        if(number.isEmpty() || number == null) throw new UnsupportedMathOperationException("Please set a numeric value");
        String nAux = number.replace(",", ".");
        return Double.parseDouble(nAux);
    }

    public static boolean isNumeric(String number) {
        if(number.isEmpty() || number == null) return false;;
        String nAux = number.replace(",", ".");
        return nAux.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
