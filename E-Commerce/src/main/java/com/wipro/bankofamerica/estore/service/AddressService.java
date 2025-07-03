package com.wipro.bankofamerica.estore.service;

import com.wipro.bankofamerica.estore.model.Address;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AddressService {

    Address saveAddress(Address address);

    Optional<Address> getAddressById(Integer id);

    void deleteAddress(Integer id);
}
