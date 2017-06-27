package by.it.milosh.service.serviceImpl;

import by.it.milosh.entity.manyToOne.Person;
import by.it.milosh.repository.dao.PersonDao;
import by.it.milosh.service.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public Person getPerson(Long person_id) {
        return personDao.getPerson(person_id);
    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void deletePersonById(Long person_id) {
        personDao.deletePersonById(person_id);
    }

    @Override
    public void addAddressToPerson(Long person_id, Long address_id) {
        personDao.addAddressToPerson(person_id, address_id);
    }
}
