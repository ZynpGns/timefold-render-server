package com.example.timefold.domain;

import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class Roster {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "employeeRange")
    private List<Employee> employeeList = new ArrayList<>();

    @ProblemFactCollectionProperty
    private List<Shift> shiftList = new ArrayList<>();

    @PlanningEntityCollectionProperty
    private List<ShiftAssignment> assignmentList = new ArrayList<>();

    @PlanningScore
    @JsonIgnore
    private HardSoftScore score;

    public Roster() {
    }

    public Roster(List<Employee> employeeList, List<Shift> shiftList, List<ShiftAssignment> assignmentList) {
        // null gelse bile boş listeye çeviriyoruz
        this.employeeList = (employeeList != null) ? employeeList : new ArrayList<>();
        this.shiftList = (shiftList != null) ? shiftList : new ArrayList<>();
        this.assignmentList = (assignmentList != null) ? assignmentList : new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = (employeeList != null) ? employeeList : new ArrayList<>();
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = (shiftList != null) ? shiftList : new ArrayList<>();
    }

    public List<ShiftAssignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<ShiftAssignment> assignmentList) {
        this.assignmentList = (assignmentList != null) ? assignmentList : new ArrayList<>();
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
