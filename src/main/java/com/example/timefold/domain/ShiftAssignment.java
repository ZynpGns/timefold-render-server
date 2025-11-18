package com.example.timefold.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class ShiftAssignment {

    @PlanningId
    private Long id;

    /** Problem fact – değişmez */
    private Shift shift;

    /** Solver'ın atadığı değişken */
    @PlanningVariable(valueRangeProviderRefs = "employeeRange")
    private Employee employee;

    public ShiftAssignment() {
    }

    public ShiftAssignment(Long id, Shift shift) {
        this.id = id;
        this.shift = shift;
    }

    // ---- getters / setters ----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
