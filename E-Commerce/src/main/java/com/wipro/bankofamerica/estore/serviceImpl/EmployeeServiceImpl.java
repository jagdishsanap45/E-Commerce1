package com.wipro.bankofamerica.estore.serviceImpl;

import com.wipro.bankofamerica.estore.model.Employee;
import com.wipro.bankofamerica.estore.repository.EmployeeRepository;
import com.wipro.bankofamerica.estore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class EmployeeServiceImpl implements EmployeeService {

        @Autowired
        private EmployeeRepository employeeRepository;

        @Override
        public Employee saveEmployee(Employee employee) {
            if (employee.getAddresses() != null) {
                employee.getAddresses().forEach(address -> address.setEmployee(employee));
            }
            return employeeRepository.save(employee);
        }


        @Override
        public Employee getEmployee(Integer id) {
            return employeeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
        }

        public void deleteEmployee(Integer id) {
            employeeRepository.deleteById(id);
        }
}

