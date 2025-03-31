package br.com.tiagolima.curso_api_rest_java_spring_boot.services;

import br.com.tiagolima.curso_api_rest_java_spring_boot.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonModel> findAll(){
        logger.info("Finding all people");
        List<PersonModel> people = new ArrayList<>();
        for(int i = 0; i<8; i++){
            PersonModel person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    public PersonModel findById(String id){
        logger.info("Finding one person");

        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Tiago");
        person.setLastName("Lima");
        person.setAddress("Formiga MG");
        person.setGender("Male");
        return person;
    }

    public PersonModel createPerson(PersonModel person){
        logger.info("Create one person");
        return person;
    }

    public PersonModel updatePerson(PersonModel person){
        logger.info("Update one person");
        return person;
    }

    public void deletePerson(String id){
        logger.info("Delete one person");
    }

    private PersonModel mockPerson(int i) {
        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Address " + i);
        person.setGender("Gender" + i);
        return person;
    }

}
