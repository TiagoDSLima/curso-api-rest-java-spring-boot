package br.com.tiagolima.curso_api_rest_java_spring_boot.math;

import br.com.tiagolima.curso_api_rest_java_spring_boot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

    public double sum(Double nOne, Double nTwo) {
        return nOne + nTwo;
    }

    public double sub(Double nOne, Double nTwo) {
        return nOne - nTwo;
    }

    public double mult(Double nOne, Double nTwo) {
        return nOne * nTwo;
    }

    public double div(Double nOne, Double nTwo) {
        return nOne / nTwo;
    }

    public double media(Double nOne, Double nTwo) {
        return (nOne + nTwo) / 2;
    }

    public double rQ(Double number) {
        return Math.sqrt(number);
    }
}
