package com.wipro.bankofamerica.estore.service;

import com.wipro.bankofamerica.estore.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public Employee getEmployee(Integer id);
    public void deleteEmployee(Integer id);
}
