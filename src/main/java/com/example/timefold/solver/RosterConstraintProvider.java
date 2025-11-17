package com.example.timefold.solver;

import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;

public class RosterConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[]{
                employeeConflict(factory),
                requiredRoleMatch(factory)
        };
    }

    // 1) Aynı çalışan aynı anda iki vardiyede olamaz
    private Constraint employeeConflict(ConstraintFactory factory) {
        return factory.fromUniquePair(com.example.timefold.domain.ShiftAssignment.class,
                        (a, b) -> a.getEmployee() != null && a.getEmployee().equals(b.getEmployee()))
                .filter((a, b) ->
                        a.getShift().getStart().isBefore(b.getShift().getEnd()) &&
                        b.getShift().getStart().isBefore(a.getShift().getEnd())
                )
                .penalize("Employee conflict", 10);
    }

    // 2) Çalışan uygun role sahip olmalı
    private Constraint requiredRoleMatch(ConstraintFactory factory) {
        return factory.from(com.example.timefold.domain.ShiftAssignment.class)
                .filter(assign ->
                        assign.getEmployee() != null &&
                        !assign.getEmployee().getSkills().contains(assign.getShift().getRole())
                )
                .penalize("Role mismatch", 5);
    }
}
