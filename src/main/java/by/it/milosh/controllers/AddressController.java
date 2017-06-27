package by.it.milosh.controllers;

import by.it.milosh.entity.manyToOne.Address;
import by.it.milosh.service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    /* работает */
    @RequestMapping(value = {"/addAddress"}, method = RequestMethod.GET)
    public String addAddress() {
        Address address = new Address("London");
        addressService.addAddress(address);
        System.out.println("Add user.");
        return "address";
    }

    /* работает */
   @RequestMapping(value = {"/getAddress"}, method = RequestMethod.GET)
    public String getAddress() {
        Address address = addressService.getAddress(1L);
        System.out.println("User: " + address.getAddressName() + " was found.");
        return "address";
    }

    @RequestMapping(value = {"/deleteAddress"}, method = RequestMethod.GET)
    public String deleteAddress() {
        return "address";
    }

    /* 1. Когда нет связей, то работает. */
    /* 2. У перзона один адресс, у адреса один перзон. Настройки по умолчанию. Когда удаляю адрес, то ошибка, что адрес ограничен внешним ключом.
     * 3. У перзона один адресс, у адреса один перзон. В классе Address над persons поставил cascade = CascadeType.ALL. Удалил адрес и по каскаду удалил перзона.
     * 4. У перзона один адресс, у адреса один перзон. В классе Address над persons поставил cascade = CascadeType.REMOVE. Удалил адрес и по каскаду удалил перзона.
     * 5. У перзона один адресс, у адреса один перзон. В классе Address над persons поставил cascade = CascadeType.MERGE. Когда удаляю адрес, то ошибка, что адрес ограничен внешним ключом.
     * 6. У перзона один адресс, у адреса один перзон. В классе Address над persons поставил cascade = CascadeType.DETACH. Когда удаляю адрес, то ошибка, что адрес ограничен внешним ключом.
     * 7. У перзона один адресс, у адреса один перзон. В классе Address над persons поставил cascade = CascadeType.PERSIST. Когда удаляю адрес, то ошибка, что адрес ограничен внешним ключом.
     * 8. У перзона один адресс, у адреса один перзон. В классе Address над persons поставил cascade = CascadeType.REFRESH. Когда удаляю адрес, то ошибка, что адрес ограничен внешним ключом.
     * 9. cascade = CascadeType.ALL, orphanRemoval = true - удалил адрес и по каскаду перзона
     * 10. cascade = CascadeType.ALL, orphanRemoval = false - удалил адрес и по каскаду перзона
     * 11. cascade = CascadeType.REMOVE, orphanRemoval = true - удалил адрес и по каскаду перзона
     * 12. cascade = CascadeType.REMOVE, orphanRemoval = false - удалил адрес и по каскаду перзона*/
    @RequestMapping(value = {"/deleteAddressById"}, method = RequestMethod.GET)
    public String deleteAddressById() {
        addressService.deleteAddressById(1L);
        System.out.println("Adress was deleted.");
        return "address";
    }

    /* Для удаления адресов нам мешают связи (внешний ключ) с перзонами. Поэтому надо избавиться от внешнего ключа: person.getAddres(null).
     * Сделать это для всех юзеров для этого адреса. А потом удалить сам адрес. */
    @RequestMapping(value = {"/deleteAddressByIdCustom"}, method = RequestMethod.GET)
    public String deleteAddressByIdCustom() {
        addressService.deleteAddressByIdCustom(1L);
        return "address";
    }


}
