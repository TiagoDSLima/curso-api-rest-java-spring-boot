package br.com.tiagolima.curso_api_rest_java_spring_boot.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}