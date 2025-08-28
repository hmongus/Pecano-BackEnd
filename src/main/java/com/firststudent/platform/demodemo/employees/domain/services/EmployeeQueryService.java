package com.firststudent.platform.demodemo.employees.domain.services;

import com.firststudent.platform.demodemo.employees.domain.model.aggregate.Employee;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetAllEmployees;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetEmployeeByDNI;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetEmployeeBySegmentation;

import java.util.List;
import java.util.Optional;

public interface EmployeeQueryService {
    Optional<Employee> handle(GetEmployeeByDNI query);
    List<Employee> handle(GetEmployeeBySegmentation query);
    List<Employee> handle(GetAllEmployees query);
}
