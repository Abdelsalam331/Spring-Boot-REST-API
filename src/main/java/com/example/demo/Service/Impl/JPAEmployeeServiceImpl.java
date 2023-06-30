package com.example.demo.Service.Impl;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.JPAEmployeeRepository;
import com.example.demo.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class JPAEmployeeServiceImpl implements EmployeeService {

    private final JPAEmployeeRepository jpaEmployeeService;

    @Override
    public Employee saveEmployee(Employee employee) {
        return jpaEmployeeService.save(employee);
    }

    @Override
    public List<Employee> getallEmployees() {
      return  jpaEmployeeService.findAll();
    };

    @Override
    public Employee getOneEmployee(int id) {
        return jpaEmployeeService.findById(id).get();
    }

    @Override
    public void updateEmployee(Employee employee) {
        jpaEmployeeService.save(employee);
    }

    @Override
    public Boolean deleteById(int id) {
        jpaEmployeeService.deleteById(id);
        return Boolean.TRUE;
    }
}
