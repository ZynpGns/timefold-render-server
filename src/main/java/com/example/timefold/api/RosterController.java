package com.example.timefold.api;

import com.example.timefold.domain.Roster;

import ai.timefold.solver.core.api.solver.SolverJob;
import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/roster")
public class RosterController {

    private final SolverManager<Roster, Long> solverManager;

    public RosterController(SolverManager<Roster, Long> solverManager) {
        this.solverManager = solverManager;
    }

    /** Flutter'dan POST ile bir Roster gönder, çözülmüş halini geri al. */
    @PostMapping("/solve")
    public Roster solve(@RequestBody Roster problem) throws ExecutionException, InterruptedException {
        long problemId = 1L; // tek problem için sabit id
        SolverJob<Roster, Long> job = solverManager.solve(problemId, id -> problem);
        return job.getFinalBestSolution();
    }
}
