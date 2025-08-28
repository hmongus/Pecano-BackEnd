package com.firststudent.platform.demodemo.employees.application.internal.queryservices;

import com.firststudent.platform.demodemo.employees.domain.model.aggregate.Employee;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetAllEmployees;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetEmployeeByDNI;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetEmployeeBySegmentation;
import com.firststudent.platform.demodemo.employees.domain.model.valueObject.EEmployeeSegmentation;
import com.firststudent.platform.demodemo.employees.domain.services.EmployeeQueryService;
import com.firststudent.platform.demodemo.employees.infrastructure.persistance.jpa.repositorie.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeQueryServiceImpl implements EmployeeQueryService {
    private final EmployeeRepository employeeRepository;
    public EmployeeQueryServiceImpl(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}

    @Override
    public List<Employee> handle(GetEmployeeBySegmentation query) {
        return employeeRepository.findAllByTipoTrabajador(EEmployeeSegmentation.valueOf(query.segmentation()));
    }

    @Override
    public Optional<Employee> handle(GetEmployeeByDNI query) {
        return employeeRepository.findByDni(query.DNI());
    }

    @Override
    public List<Employee> handle(GetAllEmployees query){
        return employeeRepository.findAll();
    }

}
