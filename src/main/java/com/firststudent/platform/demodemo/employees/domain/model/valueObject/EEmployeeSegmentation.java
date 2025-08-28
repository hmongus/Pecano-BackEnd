package com.firststudent.platform.demodemo.employees.domain.model.valueObject;

import jakarta.persistence.Entity;

public enum EEmployeeSegmentation {
    OBREROS("0"){
        @Override
        public double calcular(Integer horasLaboradas, Integer diasLaborados, Integer faltas){
            return (((horasLaboradas*diasLaborados)*15.0) - (faltas*120) + 130) *(0.12);
        }
    },
    SUPERVISORES("1"){
        @Override
        public double calcular(Integer horasLaboradas, Integer diasLaborados, Integer faltas){
            return (((horasLaboradas*diasLaborados)*35.0) - (faltas*280) + 200) *(0.16);
            }
    },
    GERENTES("2"){
        @Override
        public double calcular(Integer horasLaboradas, Integer diasLaborados, Integer faltas){
            return (((horasLaboradas*diasLaborados)*85.0) - (faltas*680) + 350) *(0.19);
        }
    };

    public final String value;

    private EEmployeeSegmentation(String value) {
        this.value = value;
    }

    public abstract double calcular(Integer horasLaboradas, Integer diasLaborados, Integer faltas);
}
