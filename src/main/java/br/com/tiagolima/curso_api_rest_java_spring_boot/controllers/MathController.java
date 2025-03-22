package br.com.tiagolima.curso_api_rest_java_spring_boot.controllers;

import br.com.tiagolima.curso_api_rest_java_spring_boot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{nOne}/{nTwo}")
    public double sum(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
            {
        if(!isNumeric(nOne) || !isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");;
        return convertToDouble(nOne) + convertToDouble(nTwo);
    }

    @RequestMapping("/subtraction/{nOne}/{nTwo}")
    public double subtraction(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
    {
        if(!isNumeric(nOne) || !isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");;
        return convertToDouble(nOne) - convertToDouble(nTwo);
    }

    @RequestMapping("/multiplication/{nOne}/{nTwo}")
    public double multiplication(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo
    ){
        if(!isNumeric(nOne) || !isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");;
        return convertToDouble(nOne) * convertToDouble(nTwo);
    }

    private double convertToDouble(String number) throws UnsupportedMathOperationException {
        if(number.isEmpty() || number == null) throw new UnsupportedMathOperationException("Please set a numeric value");
        String nAux = number.replace(",", ".");
        return Double.parseDouble(nAux);
    }

    private boolean isNumeric(String number) {
        if(number.isEmpty() || number == null) return false;;
        String nAux = number.replace(",", ".");
        return nAux.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
