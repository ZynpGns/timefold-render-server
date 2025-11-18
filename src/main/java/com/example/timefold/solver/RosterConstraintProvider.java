package com.example.timefold.solver;

import com.example.timefold.domain.Employee;
import com.example.timefold.domain.Shift;
import com.example.timefold.domain.ShiftAssignment;

import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;
import ai.timefold.solver.core.api.score.stream.Joiners;

public class RosterConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[]{
                requiredSkill(factory),
                noOverlappingShifts(factory)
        };
    }

    /** Çalışanın gerekli skill'e sahip olmaması -> hard ceza */
    private Constraint requiredSkill(ConstraintFactory factory) {
        return factory.forEach(ShiftAssignment.class)
                .filter(assignment -> {
                    Shift shift = assignment.getShift();
                    Employee e = assignment.getEmployee();
                    String required = shift.getRequiredSkill();
                    if (required == null || required.isBlank()) {
                        return false;
                    }
                    return e == null || e.getSkills() == null || !e.getSkills().contains(required);
                })
                .penalize("Missing required skill", HardSoftScore.ONE_HARD);
    }

    /** Aynı çalışanın çakışan vardiyaları -> hard ceza */
    private Constraint noOverlappingShifts(ConstraintFactory factory) {
        return factory.forEachUniquePair(
                        ShiftAssignment.class,
                        Joiners.equal(ShiftAssignment::getEmployee))
                .filter((a, b) -> a.getEmployee() != null
                        && b.getEmployee() != null
                        && a.getShift().overlaps(b.getShift()))
                .penalize("Overlapping shifts", HardSoftScore.ONE_HARD);
    }
}
