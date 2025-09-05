package br.com.tiagolima.curso_api_rest_java_spring_boot.repositorys;

import br.com.tiagolima.curso_api_rest_java_spring_boot.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
