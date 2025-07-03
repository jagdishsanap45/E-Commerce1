package com.wipro.bankofamerica.estore.controller;

import com.wipro.bankofamerica.estore.model.Address;
import com.wipro.bankofamerica.estore.model.Employee;
import com.wipro.bankofamerica.estore.service.AddressService;
import com.wipro.bankofamerica.estore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeService employeeService;

    // 1. Add a new address for an existing employee
    @PostMapping("/{employeeId}")

    public ResponseEntity<?> addAddress(@PathVariable Integer employeeId, @RequestBody Address address) {
        try {

            Employee employee = employeeService.getEmployee(employeeId);
            address.setEmployee(employee);

            Address savedAddress = addressService.saveAddress(address);
            return ResponseEntity.ok(savedAddress);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    // 2. Get all addresses for a specific employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<?> getAddressesByEmployeeId(@PathVariable Integer employeeId) {
        try {
            Employee employee = employeeService.getEmployee(employeeId);
            List<Address> addresses = employee.getAddresses();
            return ResponseEntity.ok(addresses);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    // 3. Update an address by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody Address addressDetails) {
        Optional<Address> optionalAddress = addressService.getAddressById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setStreet(addressDetails.getStreet());
            existingAddress.setCity(addressDetails.getCity());
            existingAddress.setState(addressDetails.getState());
            existingAddress.setZip(addressDetails.getZip());

            Address updatedAddress = addressService.saveAddress(existingAddress);
            return ResponseEntity.ok(updatedAddress);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
    }

    // 4. Delete an address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        try {
            addressService.deleteAddress(id);
            return ResponseEntity.ok("Address deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
    }
}

