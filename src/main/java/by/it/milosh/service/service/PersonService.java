package by.it.milosh.service.service;

import by.it.milosh.entity.manyToOne.Person;

public interface PersonService {

    void addPerson(Person person);

    Person getPerson(Long person_id);

    void deletePerson(Person person);

    void deletePersonById(Long person_id);

    void addAddressToPerson(Long person_id, Long address_id);

}
