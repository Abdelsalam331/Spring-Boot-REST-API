package com.example.demo.Service;

import com.example.demo.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

        Employee saveEmployee(Employee employee);

        List<Employee> getallEmployees();

        Employee getOneEmployee(int id);

        void updateEmployee (Employee employee);

        Boolean deleteById (int id);

    }
