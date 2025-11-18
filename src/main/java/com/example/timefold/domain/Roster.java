package com.example.timefold.domain;

import java.util.List;

import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.drools.ProblemFactProperty; // kullanılmıyor ama sorun değil
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;

@PlanningSolution
public class Roster {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "employeeRange")
    private List<Employee> employeeList;

    @ProblemFactCollectionProperty
    private List<Shift> shiftList;

    @PlanningEntityCollectionProperty
    private List<ShiftAssignment> assignmentList;

    @PlanningScore
    private HardSoftScore score;

    public Roster() {
    }

    public Roster(List<Employee> employeeList, List<Shift> shiftList, List<ShiftAssignment> assignmentList) {
        this.employeeList = employeeList;
        this.shiftList = shiftList;
        this.assignmentList = assignmentList;
    }

    // ---- getters / setters ----

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }

    public List<ShiftAssignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<ShiftAssignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
