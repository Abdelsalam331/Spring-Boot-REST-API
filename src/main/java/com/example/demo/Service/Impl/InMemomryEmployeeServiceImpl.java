package com.example.demo.Service.Impl;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.InMemomryEmployeeRepository;
import com.example.demo.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InMemomryEmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final InMemomryEmployeeRepository inMemomryEmployeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return inMemomryEmployeeRepository.saveEmployee(employee);
    }

    @Override
    public List<Employee> getallEmployees() {
        return inMemomryEmployeeRepository.getallEmployees();
    }

    @Override
    public Employee getOneEmployee(int id) {
        return inMemomryEmployeeRepository.getOneEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        inMemomryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(int id) {
        return inMemomryEmployeeRepository.deleteById(id);
    }
}
