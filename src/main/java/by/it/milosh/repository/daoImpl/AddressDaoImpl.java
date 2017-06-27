package by.it.milosh.repository.daoImpl;

import by.it.milosh.entity.manyToOne.Address;
import by.it.milosh.entity.manyToOne.Person;
import by.it.milosh.repository.dao.AddressDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAddress(Address address) {
        getSession().save(address);
    }

    @Override
    public Address getAddress(Long address_id) {
        return (Address) getSession().get(Address.class, address_id);
    }

    @Override
    public void deleteAddress(Address address) {

    }

    @Override
    public void deleteAddressById(Long address_id) {
        Address address = getSession().get(Address.class, address_id);
        getSession().delete(address);
    }

    @Override
    public void deleteAddressByIdCustom(Long address_id) {
        String allPersons = "from Person p where p.address.address_id=:address_id";
        Query query = getSession().createQuery(allPersons);
        query.setParameter("address_id", address_id);
        List<Person> persons = query.list();
        for (Person person : persons) {
            person.setAddress(null);
            getSession().save(person);
            Person person1 = getSession().get(Person.class, person.getPerson_id());
        }
        Address address = getSession().get(Address.class, address_id);
        System.out.println("OK");
        getSession().delete(address);
        System.out.println("DEL");

    }
}
