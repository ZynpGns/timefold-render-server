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

    /** Flutter'dan POST ile bir Roster gönder, çözülmüş halini geri al. */
    @PostMapping("/solve")
    public Roster solve(@RequestBody Roster problem) {
        // Her istek için yeni ve bağımsız bir solver oluştur
        Solver<Roster> solver = solverFactory.buildSolver();
        // Problemi senkron şekilde çöz ve en iyi çözümü geri döndür
        return solver.solve(problem);
    }
}
