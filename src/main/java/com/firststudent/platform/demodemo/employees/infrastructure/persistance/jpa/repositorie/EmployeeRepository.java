package com.firststudent.platform.demodemo.employees.infrastructure.persistance.jpa.repositorie;

import com.firststudent.platform.demodemo.employees.domain.model.aggregate.Employee;
import com.firststudent.platform.demodemo.employees.domain.model.valueObject.EEmployeeSegmentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByTipoTrabajador(EEmployeeSegmentation tipoTrabajador);

    Optional<Employee> findByDni(String dni);
}
