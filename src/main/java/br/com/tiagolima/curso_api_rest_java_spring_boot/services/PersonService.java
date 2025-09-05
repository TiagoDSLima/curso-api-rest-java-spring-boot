package br.com.tiagolima.curso_api_rest_java_spring_boot.services;

import br.com.tiagolima.curso_api_rest_java_spring_boot.exceptions.ResourceNotFoundException;
import br.com.tiagolima.curso_api_rest_java_spring_boot.models.PersonModel;
import br.com.tiagolima.curso_api_rest_java_spring_boot.repositorys.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<PersonModel> findAll(){
        logger.info("Finding all people");
        return personRepository.findAll();
    }

    public PersonModel findById(Long id){
        logger.info("Finding one person");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
    }

    public PersonModel createPerson(PersonModel person){
        logger.info("Create one person");
        return personRepository.save(person);
    }

    public PersonModel updatePerson(PersonModel person){
        logger.info("Update one person");
        PersonModel entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void deletePerson(Long id) {
        logger.info("Delete one person");
        PersonModel entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        personRepository.delete(entity);
    }
}
