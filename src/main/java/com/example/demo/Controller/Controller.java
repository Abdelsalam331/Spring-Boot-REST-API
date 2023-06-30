package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
@RequiredArgsConstructor
public class Controller {


    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getallEmployees(){
       return ResponseEntity.ok(employeeService.getallEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getaEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.getOneEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employee.setId(employeeService.getallEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.saveEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.deleteById(id));
    };

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    };

    private URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    };

}
