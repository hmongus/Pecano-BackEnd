package com.firststudent.platform.demodemo.employees.interfaces.transform;

import com.firststudent.platform.demodemo.employees.domain.model.aggregate.Employee;
import com.firststudent.platform.demodemo.employees.domain.model.valueObject.EEmployeeSegmentation;
import com.firststudent.platform.demodemo.employees.interfaces.rest.resources.EmployeeResource;

public class EmployeeResourceFromEntityAssembler {

    public static EmployeeResource toResourceFromEntity(Employee employee){
        EEmployeeSegmentation newOne = employee.getTipoTrabajadorOB();
        return new EmployeeResource(
                employee.getId(),
                employee.getDni(),
                employee.getHorasLaboradas(),
                employee.getDiasLaborados(),
                employee.getFaltas(),
                employee.getTipoTrabajador(),
                newOne.calcular(employee.getHorasLaboradas(),
                        employee.getDiasLaborados(),
                        employee.getFaltas())
        );
    }
}
