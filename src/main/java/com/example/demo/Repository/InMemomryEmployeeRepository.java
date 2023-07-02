//package com.example.demo.Repository;
//
//import com.example.demo.Model.Employee;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InMemomryEmployeeRepository {
//    private static final List<Employee> employeesData = new ArrayList<>();
//
//    static {
//        employeesData.add(new Employee(
//                        1,
//                        "Abdelsalam",
//                        "Mohamed",
//                        "Abdelsalam@gmail.com"
//                )
//        );
//        employeesData.add(new Employee(
//                        2,
//                        "Yara",
//                        "Ahmed",
//                        "Abdelsalam@gmail.com"
//                )
//        );
//        employeesData.add(new Employee(
//                        3,
//                        "Mahmoud",
//                        "Mohamed",
//                        "Abdelsalam@gmail.com"
//                )
//        );
//    }
//
//    public Employee saveEmployee(Employee employee){
//        employeesData.add(employee);
//        return employee;
//    };
//
//    public List<Employee> getallEmployees(){
//        return List.copyOf(employeesData);
//    };
//
//    public Employee getOneEmployee(Integer id){
//        return employeesData
//                .stream()
//                .filter(emp -> id.equals(emp.getId()))
//                .findFirst()
//                .orElseThrow();
//    };
//
//    public void updateEmployee (Employee employee) {
//        Employee var = employeesData
//                .stream()
//                .filter(emp -> employee.getId().equals(emp.getId()))
//                .findFirst()
//                .orElseThrow();
//
//        var.setId(employee.getId());
//        var.setEmail(employee.getEmail());
//        var.setFirstName(employee.getFirstName());
//        var.setFirstName(employee.getFirstName());
//
//    };
//
//    public Boolean deleteById (Integer id){
//        Employee deletedEmployee = employeesData
//                .stream()
//                .filter(emp -> id.equals(emp.getId()))
//                .findFirst()
//                .orElseThrow();
//
//        employeesData.remove(deletedEmployee);
//        return Boolean.TRUE;
//    };
//
//}