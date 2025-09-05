package br.com.tiagolima.curso_api_rest_java_spring_boot.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
public class PersonModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME", nullable = false, length = 80)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false, length = 80)
    private String lastName;
    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;
    @Column(name = "GENDER", nullable = false, length = 6)
    private String gender;

    public PersonModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonModel personModel)) return false;
        return Objects.equals(id, personModel.id) && Objects.equals(firstName, personModel.firstName) && Objects.equals(lastName, personModel.lastName) && Objects.equals(address, personModel.address) && Objects.equals(gender, personModel.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
