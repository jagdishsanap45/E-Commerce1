package com.wipro.bankofamerica.estore.repository;

import com.wipro.bankofamerica.estore.model.Address;
import com.wipro.bankofamerica.estore.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer > {
}
