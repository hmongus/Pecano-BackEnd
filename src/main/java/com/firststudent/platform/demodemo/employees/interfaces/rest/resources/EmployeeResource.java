package com.firststudent.platform.demodemo.employees.interfaces.rest.resources;

import com.firststudent.platform.demodemo.employees.domain.model.valueObject.EEmployeeSegmentation;

public record EmployeeResource(Long id, String dni,Integer horasLaboradas,Integer diasLaborados ,Integer Faltas, String tipoTrabajador, Double calcular) {
}
