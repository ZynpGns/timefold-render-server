package com.example.timefold.api;

import com.example.timefold.domain.Roster;

import ai.timefold.solver.core.api.solver.Solver;
import ai.timefold.solver.core.api.solver.SolverFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roster")
public class RosterController {

    private final SolverFactory<Roster> solverFactory;

    public RosterController(SolverFactory<Roster> solverFactory) {
        this.solverFactory = solverFactory;
    }

    @PostMapping("/solve")
    public Roster solve(@RequestBody Roster problem) {
        // Burada sadece solver'ı oluşturup aynı thread'de çözdürüyoruz
        Solver<Roster> solver = solverFactory.buildSolver();
        return solver.solve(problem);
    }
}
