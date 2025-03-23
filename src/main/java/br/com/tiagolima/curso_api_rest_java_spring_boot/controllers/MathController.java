package br.com.tiagolima.curso_api_rest_java_spring_boot.controllers;

import br.com.tiagolima.curso_api_rest_java_spring_boot.exception.UnsupportedMathOperationException;
import br.com.tiagolima.curso_api_rest_java_spring_boot.math.SimpleMath;
import br.com.tiagolima.curso_api_rest_java_spring_boot.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath simpleMath = new SimpleMath();

    @RequestMapping("/sum/{nOne}/{nTwo}")
    public Double sum(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
    {
        if(!NumberConverter.isNumeric(nOne) || !NumberConverter.isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a valid number");
        return simpleMath.sum(NumberConverter.convertToDouble(nOne), NumberConverter.convertToDouble(nTwo));
    }

    @RequestMapping("/sub/{nOne}/{nTwo}")
    public Double sub(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
    {
        if(!NumberConverter.isNumeric(nOne) || !NumberConverter.isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a valid number");
        return simpleMath.sub(NumberConverter.convertToDouble(nOne), NumberConverter.convertToDouble(nTwo));
    }

    @RequestMapping("/mult/{nOne}/{nTwo}")
    public Double mult(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
    {
        if(!NumberConverter.isNumeric(nOne) || !NumberConverter.isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a valid number");
        return simpleMath.mult(NumberConverter.convertToDouble(nOne), NumberConverter.convertToDouble(nTwo));
    }

    @RequestMapping("/div/{nOne}/{nTwo}")
    public Double div(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
    {
        if(!NumberConverter.isNumeric(nOne) || !NumberConverter.isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a valid number");
        return simpleMath.div(NumberConverter.convertToDouble(nOne), NumberConverter.convertToDouble(nTwo));
    }

    @RequestMapping("/media/{nOne}/{nTwo}")
    public Double media(
            @PathVariable("nOne") String nOne,
            @PathVariable("nTwo") String nTwo)
    {
        if(!NumberConverter.isNumeric(nOne) || !NumberConverter.isNumeric(nTwo)) throw new UnsupportedMathOperationException("Please set a valid number");
        return simpleMath.media(NumberConverter.convertToDouble(nOne), NumberConverter.convertToDouble(nTwo));
    }

    @RequestMapping("/rQ/{number}")
    public Double rQ(
            @PathVariable("number") String number)
    {
        if(!NumberConverter.isNumeric(number)) throw new UnsupportedMathOperationException("Please set a valid number");
        return simpleMath.rQ(NumberConverter.convertToDouble(number));
    }

}
