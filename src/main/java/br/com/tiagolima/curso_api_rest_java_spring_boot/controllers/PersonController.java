package br.com.tiagolima.curso_api_rest_java_spring_boot.controllers;

import br.com.tiagolima.curso_api_rest_java_spring_boot.models.PersonModel;
import br.com.tiagolima.curso_api_rest_java_spring_boot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel findById(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonModel> findAll() {
        return personService.findAll();
    }
}
