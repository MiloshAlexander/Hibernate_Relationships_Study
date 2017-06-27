package by.it.milosh.repository.daoImpl;

import by.it.milosh.entity.manyToOne.Address;
import by.it.milosh.entity.manyToOne.Person;
import by.it.milosh.repository.dao.PersonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPerson(Person person) {
        getSession().save(person);
    }

    @Override
    public Person getPerson(Long person_id) {
        return (Person) getSession().get(Person.class, person_id);
    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void deletePersonById(Long person_id) {
        Person person = getSession().get(Person.class, person_id);
        getSession().delete(person);
        System.out.println(person.getPersonName());
    }

    @Override
    public void addAddressToPerson(Long person_id, Long address_id) {
        Person person = getSession().get(Person.class, person_id);
        Address address = getSession().get(Address.class, address_id);
        person.setAddress(address);
        getSession().save(person);
    }
}
