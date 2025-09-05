package br.com.tiagolima.curso_api_rest_java_spring_boot.controllers;

import br.com.tiagolima.curso_api_rest_java_spring_boot.models.PersonModel;
import br.com.tiagolima.curso_api_rest_java_spring_boot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public PersonModel findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonModel> findAll() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel create(@RequestBody PersonModel person) {
        return personService.createPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel update(@RequestBody PersonModel person) {
        return personService.updatePerson(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}
