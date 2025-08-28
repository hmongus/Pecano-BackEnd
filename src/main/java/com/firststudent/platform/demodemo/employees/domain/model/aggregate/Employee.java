package com.firststudent.platform.demodemo.employees.domain.model.aggregate;

import com.firststudent.platform.demodemo.employees.domain.model.valueObject.EEmployeeSegmentation;
import jakarta.persistence.*;

@Entity
@Table(name = "employee") // o @Table(name="trabajadores") si quieres ese nombre
@Access(AccessType.FIELD) // usa acceso por campo, ignora getters/setters para el mapeo
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "horas_laboradas")
    private Integer horasLaboradas;

    @Column(name = "dias_laborados")
    private Integer diasLaborados;

    @Column(name = "faltas")
    private Integer faltas;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_trabajador")
    private EEmployeeSegmentation tipoTrabajador;

    protected Employee() {}

    public Long getId(){
        return id;
    }

    public String getDni(){
        return dni;
    }
    public Integer getHorasLaboradas(){
        return horasLaboradas;
    }
    public Integer getDiasLaborados(){
        return diasLaborados;
    }
    public Integer getFaltas(){
        return faltas;
    }
    public String getTipoTrabajador(){
        return tipoTrabajador.value;
    }
    public EEmployeeSegmentation getTipoTrabajadorOB(){ return tipoTrabajador; }

    public Employee(String DNI, Integer horasLaboradas, Integer diasLaborados, Integer faltas,String tipoTrabajador) {
        this.dni = DNI;
        this.horasLaboradas = horasLaboradas;
        this.diasLaborados = diasLaborados;
        this.faltas = faltas;
        this.tipoTrabajador = EEmployeeSegmentation.valueOf(tipoTrabajador);
    }

}
