package by.it.milosh.entity.manyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long address_id;

    @Column(name = "address_name")
    private String addressName;

    @OneToMany(mappedBy = "address")
    private List<Person> persons = new ArrayList<Person>();

    public Address() {
    }

    public Address(String addressName) {
        this.addressName = addressName;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
