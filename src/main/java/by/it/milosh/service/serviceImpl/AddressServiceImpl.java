package by.it.milosh.service.serviceImpl;

import by.it.milosh.entity.manyToOne.Address;
import by.it.milosh.repository.dao.AddressDao;
import by.it.milosh.service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public void addAddress(Address address) {
        addressDao.addAddress(address);
    }

    @Override
    public Address getAddress(Long address_id) {
        return addressDao.getAddress(address_id);
    }

    @Override
    public void deleteAddress(Address address) {

    }

    @Override
    public void deleteAddressById(Long address_id) {
        addressDao.deleteAddressById(address_id);
    }

    @Override
    public void deleteAddressByIdCustom(Long address_id) {
        addressDao.deleteAddressByIdCustom(address_id);
    }
}
