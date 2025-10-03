package br.com.tiagolima.curso_api_rest_java_spring_boot.mapper.custom;

import br.com.tiagolima.curso_api_rest_java_spring_boot.data.dto.v2.PersonDTOV2;
import br.com.tiagolima.curso_api_rest_java_spring_boot.models.PersonModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDto(PersonModel person){

        PersonDTOV2 dto = new PersonDTOV2();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDate(LocalDate.now());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public PersonModel convertDtoToEntity(PersonDTOV2 person){

        PersonModel entity = new PersonModel();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
