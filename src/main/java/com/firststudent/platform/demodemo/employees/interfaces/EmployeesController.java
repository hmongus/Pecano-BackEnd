package com.firststudent.platform.demodemo.employees.interfaces;

import com.firststudent.platform.demodemo.employees.domain.model.aggregate.Employee;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetAllEmployees;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetEmployeeByDNI;
import com.firststudent.platform.demodemo.employees.domain.model.queries.GetEmployeeBySegmentation;
import com.firststudent.platform.demodemo.employees.domain.model.valueObject.EEmployeeSegmentation;
import com.firststudent.platform.demodemo.employees.domain.services.EmployeeQueryService;
import com.firststudent.platform.demodemo.employees.interfaces.rest.resources.EmployeeResource;
import com.firststudent.platform.demodemo.employees.interfaces.transform.EmployeeResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeesController {

    private final EmployeeQueryService employeeQueryService;

    public EmployeesController(EmployeeQueryService employeeQueryService) {
        this.employeeQueryService = employeeQueryService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResource>> getAllEmployees() {
        var results = employeeQueryService.handle(new GetAllEmployees());
        if(results.isEmpty()) return ResponseEntity.notFound().build();
        var resources = results.stream()
                .map(EmployeeResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }


    @GetMapping("/by-segmentation/{EnumNumber}")
    public ResponseEntity<List<EmployeeResource>> getEmployeesBasedOnEnum(@PathVariable String EnumNumber) {

        var result = employeeQueryService.handle(new GetEmployeeBySegmentation(EnumNumber));
        if (result.isEmpty()) { return ResponseEntity.notFound().build(); }
        var resources = result.stream()
                .map(EmployeeResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        
        return ResponseEntity.ok(resources);
    }
    
    @GetMapping("/use-dni/{DNI}")
    public ResponseEntity<EmployeeResource> getEmployeeByDNI(@PathVariable String DNI) {
        var query = new GetEmployeeByDNI(DNI);
        var result = employeeQueryService.handle(query);
        if (result.isEmpty()) { return ResponseEntity.notFound().build(); }
        var resource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(result.get());
        return ResponseEntity.ok(resource);
    }

}
