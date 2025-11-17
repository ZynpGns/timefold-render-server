package com.example.timefold.domain;

import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.variable.PlanningScore;
import ai.timefold.solver.core.api.score.Score;

import java.util.List;

@PlanningSolution
public class Roster {

    @ProblemFactCollectionProperty
    private List<Employee> employeeList;

    @ProblemFactCollectionProperty
    private List<Shift> shiftList;

    @PlanningEntityCollectionProperty
    private List<ShiftAssignment> assignmentList;

    @PlanningScore
    private Score score;

    public List<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(List<Employee> employeeList) { this.employeeList = employeeList; }

    public List<Shift> getShiftList() { return shiftList; }
    public void setShiftList(List<Shift> shiftList) { this.shiftList = shiftList; }

    public List<ShiftAssignment> getAssignmentList() { return assignmentList; }
    public void setAssignmentList(List<ShiftAssignment> assignmentList) { this.assignmentList = assignmentList; }

    public Score getScore() { return score; }
    public void setScore(Score score) { this.score = score; }
}
