package by.it.milosh.entity.manyToOne;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "person_name")
    private String personName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Person() {
    }

    public Person(String personName) {
        this.personName = personName;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
