package com.example.timefold.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class ShiftAssignment {

    private Long id;

    private Shift shift;

    @PlanningVariable
    private Employee employee;

    public ShiftAssignment() {}

    public ShiftAssignment(Long id, Shift shift) {
        this.id = id;
        this.shift = shift;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Shift getShift() { return shift; }
    public void setShift(Shift shift) { this.shift = shift; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
