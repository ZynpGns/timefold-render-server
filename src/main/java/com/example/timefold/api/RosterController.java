package com.example.timefold.api;

import com.example.timefold.domain.Roster;
import com.example.timefold.domain.Employee;
import com.example.timefold.domain.Shift;
import com.example.timefold.domain.ShiftAssignment;
import org.springframework.web.bind.annotation.*;
import ai.timefold.solver.spring.boot.autoconfigure.SolverManager;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roster")
public class RosterController {

    private final SolverManager<Roster, Long> solverManager;

    public RosterController(SolverManager<Roster, Long> solverManager) {
        this.solverManager = solverManager;
    }

    @PostMapping("/solve")
    public Roster solve(@RequestBody Roster roster) {
        return solverManager.solveAndWait(1L, id -> roster);
    }

    @GetMapping("/ping")
    public String check() {
        return "Timefold Server is running ✔";
    }
}
