package com.example.timefold.api;

import com.example.timefold.domain.Roster;

import ai.timefold.solver.core.api.solver.SolverJob;
import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;   // ✅ YENİ IMPORT

@RestController
@RequestMapping("/api/roster")
public class RosterController {

    private final SolverManager<Roster, Long> solverManager;

    // ✅ Her istek için benzersiz problemId üretmek için sayaç
    private final AtomicLong problemIdSequence = new AtomicLong(0L);

    public RosterController(SolverManager<Roster, Long> solverManager) {
        this.solverManager = solverManager;
    }

    /** Flutter'dan POST ile bir Roster gönder, çözülmüş halini geri al. */
    @PostMapping("/solve")
    public Roster solve(@RequestBody Roster problem) throws ExecutionException, InterruptedException {
        // ❌ long problemId = 1L;
        // ✅ Her istekte farklı bir problemId ver
        long problemId = problemIdSequence.incrementAndGet();

        SolverJob<Roster, Long> job = solverManager.solve(problemId, problem);
        return job.getFinalBestSolution();
    }
}
