package br.com.tiagolima.curso_api_rest_java_spring_boot.services;

import br.com.tiagolima.curso_api_rest_java_spring_boot.exceptions.ResourceNotFoundException;
import br.com.tiagolima.curso_api_rest_java_spring_boot.data.dto.PersonDTO;
import static br.com.tiagolima.curso_api_rest_java_spring_boot.mapper.ObjectMapper.parseListObjects;
import static br.com.tiagolima.curso_api_rest_java_spring_boot.mapper.ObjectMapper.parseObject;

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

    public List<PersonDTO> findAll(){
        logger.info("Finding all people");
        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one person");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO createPerson(PersonDTO person){
        logger.info("Create one person");
        var entity = parseObject(person, PersonModel.class);
        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO updatePerson(PersonDTO person){
        logger.info("Update one person");
        PersonModel entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void deletePerson(Long id) {
        logger.info("Delete one person");
        PersonModel entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        personRepository.delete(entity);
    }
}
